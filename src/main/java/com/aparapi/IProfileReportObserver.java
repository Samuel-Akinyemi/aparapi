/**
 * Copyright (c) 2016 - 2018 Syncleus, Inc.
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
package com.aparapi;

import com.aparapi.device.Device;

/**
 * Defines interface for listener/observer of Kernel profile reports 
 * 
 * @author lpnm
 */
public interface IProfileReportObserver {
	
	/**
	 * The listener method will be invoked each time a profile report becomes available for each Aparapi Kernel which has
	 * a registered observer.<br/>
	 * <b>Note1: </b>A report will be generated by a thread executing a kernel, but if multiple threads execute the same kernel,
	 * on the same device, the report rate is limited to a single thread at a time per kernel per device.<br/>
	 * <br/>
	 * <b>Note2: </b>When an observer is registered there is no need to acknowledge the reception of a profile report, a new
	 * one will be automatically generated when another thread runs the same kernel on the same device.
	 * <br/>
	 * @param kernelClass the class of the kernel to which the profile report pertains
	 * @param device the device on which the kernel ran, producing the profile report
	 * @param profileInfo the profile report for the given Aparapi kernel and device pair
	 */
	public void receiveReport(final Class<? extends Kernel> kernelClass, final Device device, final ProfileReport profileInfo);

}
