/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.functions.python;

import org.apache.flink.annotation.Internal;
import org.apache.flink.util.Preconditions;

/**
 * A simple implementation of {@link PythonFunction}.
 */
@Internal
public final class SimplePythonFunction implements PythonFunction {

	private static final long serialVersionUID = 1L;

	/**
	 * Serialized representation of the user-defined python function.
	 */
	private final byte[] serializedPythonFunction;

	/**
	 * Python execution environment.
	 */
	private final PythonEnv pythonEnv;

	/**
	 * The kind of the user-defined python function.
	 */
	private final PythonFunctionKind pythonFunctionKind;

	public SimplePythonFunction(byte[] serializedPythonFunction, PythonEnv pythonEnv, PythonFunctionKind pythonFunctionKind) {
		this.serializedPythonFunction = Preconditions.checkNotNull(serializedPythonFunction);
		this.pythonEnv = Preconditions.checkNotNull(pythonEnv);
		this.pythonFunctionKind = Preconditions.checkNotNull(pythonFunctionKind);
	}

	@Override
	public byte[] getSerializedPythonFunction() {
		return serializedPythonFunction;
	}

	@Override
	public PythonEnv getPythonEnv() {
		return pythonEnv;
	}

	@Override
	public PythonFunctionKind getPythonFunctionKind() {
		return pythonFunctionKind;
	}
}
