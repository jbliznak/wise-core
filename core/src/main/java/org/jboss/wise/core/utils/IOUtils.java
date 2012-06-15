/*
 * JBoss, Home of Professional Open Source Copyright 2006, JBoss Inc., and
 * individual contributors as indicated by the @authors tag. See the
 * copyright.txt in the distribution for a full listing of individual
 * contributors.
 * 
 * This is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA, or see the FSF
 * site: http://www.fsf.org.
 */

package org.jboss.wise.core.utils;

// $Id: IOUtils.java 4018 2007-07-27 06:31:03Z thomas.diesler@jboss.com $

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jboss.wise.core.exception.WiseRuntimeException;

/**
 * IO utilites
 * 
 * @author stefano.maestri@javalinux.it class imported from JBossWS. Kept methods useful for Wise
 */
public final class IOUtils {
    // Hide the constructor
    private IOUtils() {
    }

    public static IOUtils newInstance() {
        return new IOUtils();
    }

    /**
     * True if the given type name is the source notation of a primitive or array of which.
     * 
     * @param outs
     * @param ins
     * @throws WiseRuntimeException
     */
    public void copyStreamAndClose( OutputStream outs,
                                    InputStream ins ) throws WiseRuntimeException {
        try {
            byte[] bytes = new byte[1024];
            int r = ins.read(bytes);
            while (r > 0) {
                outs.write(bytes, 0, r);
                r = ins.read(bytes);
            }
        } catch (Exception e) {
            throw new WiseRuntimeException(e);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException e) {
                // suppressed
            }

            try {
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
            }

        }
    }

}