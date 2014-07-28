package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeaderLogged;

/**
 *
 * @author m.prytkova
 */
public class ServicePageLogged extends ServicePage {

    private FullscreenHeaderLogged fullscreenHeaderLogged;

    public FullscreenHeaderLogged getFullscreenHeaderLogged() {
        return elem(fullscreenHeaderLogged);
    }

}
