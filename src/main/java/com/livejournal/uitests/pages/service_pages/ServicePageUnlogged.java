package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeaderUnlogged;

/**
 *
 * @author m.prytkova
 */
public class ServicePageUnlogged extends ServicePage {

    private FullscreenHeaderUnlogged fullscreenHeaderUnlogged;

    public FullscreenHeaderUnlogged getFullscreenHeaderUnlogged() {
        return elem(fullscreenHeaderUnlogged);
    }

}
