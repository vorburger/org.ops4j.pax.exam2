/*
 * Copyright 2013 Harald Wellmann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.ops4j.pax.exam.junit.impl;

import org.junit.runners.model.FrameworkMethod;
import org.ops4j.pax.exam.TestAddress;

/**
 * Decorates a framework method with a parameter index. Used for parameterized tests
 * with {@code PaxExamParameterized}.
 *
 * @author Harald Wellmann
 *
 */
class ParameterizedFrameworkMethod extends DecoratedFrameworkMethod {

    ParameterizedFrameworkMethod(TestAddress address, FrameworkMethod frameworkMethod) {
        super(address, frameworkMethod);
    }

    @Override
    public String getName() {

    	// arg[0] must be an integer (at least, for the JUnit runner).
    	// The customized (parameterized) name is given as a second argument.

    	String result;
    	if( this.address.arguments().length > 1 )
    		result = String.format("%s", this.address.arguments()[1]);
    	else
    		result = String.format("%s[%d]", this.frameworkMethod.getName(), this.address.arguments()[0]);

        return result;
    }
}
