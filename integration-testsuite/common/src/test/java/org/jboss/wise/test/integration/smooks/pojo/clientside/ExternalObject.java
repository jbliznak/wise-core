/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.wise.test.integration.smooks.pojo.clientside;

import java.io.Serializable;
import java.util.Date;

public class ExternalObject implements Serializable {

    private InternalObject internal;

    private Date date;

    public InternalObject getInternal() {
        return internal;
    }

    public void setInternal(InternalObject internal) {
        this.internal = internal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{internal = ");
        sb.append(internal != null ? internal.toString() : "");
        sb.append(", date = " );
        sb.append(date);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExternalObject) {
            ExternalObject o = (ExternalObject)obj;
            return (internal == null ? o.internal == null : internal.equals(o.internal)) && (date == null ? o.date == null : date.equals(o.date));
        }
        return false;
    }

}
