/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.unified_scheme.internal;

/**
 *
 * @author s.savinykh
 */
public class Child1Class extends ParentClass{
    
    Inner1ChildtClass inner1ChildClass;
    
    public void m2() {
        inner1ChildClass.m2();
    }

    @Override
    protected Inner1ChildtClass getInnerParentClass() {
        return inner1ChildClass;
    }
}
