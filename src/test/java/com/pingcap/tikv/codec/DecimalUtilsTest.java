// Copyright 2016 PingCAP, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// See the License for the specific language governing permissions and
// limitations under the License.

package com.pingcap.tikv.codec;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;
public class DecimalUtilsTest {
    @Test
    public void readDecimalFullyTest() throws Exception {
        CodecDataOutput cdo = new CodecDataOutput();
        DecimalUtils.writeDecimalFully(cdo, 206.0);
        CodecDataInput cdi = new CodecDataInput(cdo.toBytes());
        double value = DecimalUtils.readDecimalFully(cdi);
        assertEquals(206.0, value, 0.0001);
    }
}
