package com.livejournal.uitests.console;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author s.savinykh
 */
public class SSHComands {

    private static final int SSH_PORT = 22;
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int BUFFER_SIZE = 1024;
    private static final String HOSTNAME = Injectors.getInjector().getInstance(EnvironmentVariables.class).copy().getProperty("webdriver.base.url");//"172.19.9.80";
    private static final String USERNAME = "lj";
    private static final String PASSWORD = "test";

    private Session initSession() throws JSchException {
        JSch jsch = new JSch();
        JSch.setConfig("StrictHostKeyChecking", "no");
        Session session = jsch.getSession(USERNAME, HOSTNAME, SSH_PORT);
        session.setPassword(PASSWORD);
        session.connect(CONNECTION_TIMEOUT);
        return session;
    }

    private Channel initChannel(String commands, Session session) throws JSchException {
        Channel channel = session.openChannel("exec");
        ChannelExec channelExec = (ChannelExec) channel;
        channelExec.setCommand(commands);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        return channel;
    }

    private String getDataFromChannel(Channel channel, InputStream in) throws IOException {
        StringBuilder result = new StringBuilder();
        byte[] tmp = new byte[BUFFER_SIZE];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, BUFFER_SIZE);
                if (i < 0) {
                    break;
                }
                String rawout = new String(tmp, 0, i);
                System.out.println(rawout);
                result.append(rawout);
            }
            if (channel.isClosed()) {
                int exitStatus = channel.getExitStatus();
                System.out.println("exit-status: " + exitStatus);
                break;
            }
            trySleep(1000);
        }
        return result.toString();
    }

    private void trySleep(int sleepTimeInMilliseconds) {
        try {
            Thread.sleep(sleepTimeInMilliseconds);
        } catch (Exception e) {
        }
    }

    public List<String> restartVarnish() {
        List<String> lines = new ArrayList<String>();
        try {
            String command = "sudo /etc/init.d/varnish restart\n";
            Session session = initSession();
            Channel channel = initChannel(command, session);
            InputStream in = channel.getInputStream();
            channel.connect();
            String dataFromChannel = getDataFromChannel(channel, in);
            lines.addAll(Arrays.asList(dataFromChannel.split("\n")));
            channel.disconnect();
            session.disconnect();
            System.out.println("Varnish restarted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return lines;
    }

    public List<String> restartMemcached() {
        List<String> lines = new ArrayList<String>();
        try {
            String command = "sudo /etc/init.d/memcached restart\n";
            Session session = initSession();
            Channel channel = initChannel(command, session);
            InputStream in = channel.getInputStream();
            channel.connect();
            channel.run();
            String dataFromChannel = getDataFromChannel(channel, in);
            lines.addAll(Arrays.asList(dataFromChannel.split("\n")));
            channel.disconnect();
            session.disconnect();
            System.out.println("Memcached restarted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return lines;
    }

    public List<String> update_machine() {
        List<String> lines = new ArrayList<String>();
        try {
            String command = "up_lj\n";
            Session session = initSession();
            Channel channel = initChannel(command, session);
            InputStream in = channel.getInputStream();
            channel.connect();
            String dataFromChannel = getDataFromChannel(channel, in);
            lines.addAll(Arrays.asList(dataFromChannel.split("\n")));
            channel.disconnect();
            session.disconnect();
            System.out.println("Machine updated");
        } catch (Exception e) {
            System.out.println(e);
        }
        return lines;
    }

}
