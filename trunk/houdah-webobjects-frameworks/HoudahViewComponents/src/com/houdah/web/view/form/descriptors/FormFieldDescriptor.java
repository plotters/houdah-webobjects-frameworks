/*
 * Modified MIT License
 * 
 * Copyright (c) 2006-2007 Houdah Software s.à r.l.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * Except as contained in this notice, the name(s) of the above copyright holders
 * shall not be used in advertising or otherwise to promote the sale, use or other 
 * dealings in this Software without prior written authorization.
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
**/

package com.houdah.web.view.form.descriptors;

import com.houdah.web.view.descriptors.CellDescriptor;
import com.houdah.web.view.form.cells.FormFieldCell;
import com.houdah.web.view.form.values.ValueContainer;

public abstract class FormFieldDescriptor extends CellDescriptor
{
	// Private instance variables
	
	/**
	 * Descriptor for the optional label cell
	 */
	private FormLabelDescriptor	labelDescriptor;
	
	
	
	/**
	 * A CSS class name
	 */
	private String				cssClass;
	
	
	
	
	// Constructor
	
	/**
	 * Designated constructor
	 * 
	 * @param labelDescriptor
	 *            Descriptor for the label cell. Optional
	 * @param cssClass
	 *            CSS class to apply to the field. Optional
	 */
	public FormFieldDescriptor(FormLabelDescriptor labelDescriptor,
			boolean mayUseAccessKey, String cssClass)
	{
		this.labelDescriptor = labelDescriptor;
		this.cssClass = cssClass;
	}
	
	
	
	/**
	 * Designated constructor
	 * 
	 * @param labelDescriptor
	 *            Descriptor for the label cell. Optional
	 * @param cssClass
	 *            CSS class to apply to the field. Optional
	 */
	public FormFieldDescriptor(FormLabelDescriptor labelDescriptor,
			String cssClass)
	{
		this(labelDescriptor, true, cssClass);
	}
	
	
	
	// Public instance methods
	
	/**
	 * Descriptor for the optional label cell
	 * 
	 * @return a FormLabelDescriptor. May be null
	 */
	public FormLabelDescriptor labelDescriptor()
	{
		return this.labelDescriptor;
	}
	
	
	
	/**
	 * CSS class to assign to the field
	 * 
	 * @return a CSS class name
	 */
	public String cssClass(ValueContainer values)
	{
		return this.cssClass;
	}
	
	
	
	// Protected instance methods
	
	/**
	 * Determines the class the element must be a subclass of
	 * 
	 * @return a concrete or abstract subclass of the Cell element
	 */
	protected Class baseClass()
	{
		return FormFieldCell.class;
	}
}