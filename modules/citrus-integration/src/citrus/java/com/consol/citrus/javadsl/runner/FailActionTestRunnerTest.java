/*
 * Copyright 2006-2015 the original author or authors.
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

package com.consol.citrus.javadsl.runner;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.builder.AssertExceptionBuilder;
import com.consol.citrus.dsl.builder.BuilderSupport;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.exceptions.CitrusRuntimeException;
import org.testng.annotations.Test;

/**
 * @author Christoph Deppisch
 */
@Test
public class FailActionTestRunnerTest extends TestNGCitrusTestRunner {
    
    @CitrusTest
    public void FailActionTestRunnerTest() {
        assertException(new BuilderSupport<AssertExceptionBuilder>() {
            @Override
            public void configure(AssertExceptionBuilder builder) {
                builder.exception(CitrusRuntimeException.class)
                        .message("Failing ITest");
            }
        }).when(fail("Failing ITest"));

        assertException(new BuilderSupport<AssertExceptionBuilder>() {
            @Override
            public void configure(AssertExceptionBuilder builder) {
                builder.exception(CitrusRuntimeException.class)
                        .message("@startsWith('Missing asserted exception')@");
            }
        }).when(assertException().when(sleep(500)));
    }
}