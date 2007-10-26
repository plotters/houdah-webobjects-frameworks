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

import com.houdah.web.view.form.cells.HVCFormDatefieldValueFieldCell;

import com.webobjects.foundation.NSTimestampFormatter;

public class FormDatefieldValueFieldDescriptor extends FormTextfieldValueFieldDescriptor
{
	
	
	// Constructor
	
	/**
	 * Designated constructor
	 * 
	 * @param key
	 *            used for value look-up/storage in the form's value dictionary
	 * @param label
	 *            for display
	 * @param formatter
	 *            timestamp formatter. e.g. new NSTimestampFormatter("%d/%m/%y")
	 * @param valueClass
	 *            class of the value value. A subclass of Value
	 * @param cssClass
	 *            CSS class to apply to the field
	 */
	public FormDatefieldValueFieldDescriptor(String key, String label,
			NSTimestampFormatter formatter, Class valueClass, String cssClass)
	{
		super(key, label, formatter, 10, new Integer(10), null, valueClass, cssClass);
	}
	
	
	
	// Public instance methods
	
	// Protected instance methods
	
	/**
	 * Determines the cell component used for display
	 * 
	 * @return a concrete subclass of the baseClass()
	 */
	protected Class cellClass()
	{
		return HVCFormDatefieldValueFieldCell.class;
	}
}