/*
 * Copyright 2016 Kejun Xia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shipdream.lib.poke.exception;

import com.shipdream.lib.poke.Graph;

import java.lang.annotation.Annotation;

/**
 * Exception occurs when a {@link Graph} fails to find a provider by given injection type
 */
public class ProviderMissingException extends PokeException{
    public ProviderMissingException(Class instanceType, Annotation qualifier) {
        super(makeMessage(instanceType, qualifier));
    }

    public ProviderMissingException(Class instanceType, Annotation qualifier, Throwable cause) {
        super(makeMessage(instanceType, qualifier), cause);
    }

    public ProviderMissingException(String message) {
        super(message);
    }

    public ProviderMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    private static String makeMessage(Class instanceType, Annotation qualifier) {
        if (qualifier == null) {
            return String.format("Provider for type without qualifier: %s cannot be found.", instanceType.getName());
        } else {
            return String.format("Provider for type: %s, qualifier: %s cannot be found.",
                    instanceType.getName(), qualifier.toString());
        }

    }
}
