/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.homematic.internal.communicator.parser;

import java.io.IOException;
import java.util.Map;

/**
 * Parses a getDeviceDescription message and extracts the type and firmware version.
 *
 * @author Gerhard Riegler - Initial contribution
 */
public class GetDeviceDescriptionParser extends CommonRpcParser<Object[], Void> {
    private String type;
    private String firmware;
    private String deviceInterface;

    @SuppressWarnings("unchecked")
    @Override
    public Void parse(Object[] message) throws IOException {
        if (message != null && message.length > 0 && message[0] instanceof Map) {
            Map<String, ?> mapMessage = (Map<String, ?>) message[0];
            type = toString(mapMessage.get("TYPE"));
            firmware = toString(mapMessage.get("FIRMWARE"));
            deviceInterface = toString(mapMessage.get("INTERFACE"));
        }
        return null;
    }

    /**
     * Returns the parsed type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the parsed firmware version.
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Returns the interface of the device.
     */
    public String getDeviceInterface() {
        return deviceInterface;
    }
}
