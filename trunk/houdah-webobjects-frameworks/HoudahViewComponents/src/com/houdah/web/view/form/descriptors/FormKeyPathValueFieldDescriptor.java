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

import java.text.Format;

import com.houdah.foundation.KVCUtility;

public abstract class FormKeyPathValueFieldDescriptor extends
		FormSimpleValueFieldDescriptor
{
	// Private instance variables
	
	private String	keyPath;
	
	
	
	
	// Constructor
	
	/**
	 * Designated constructor
	 * 
	 * @param key
	 *            used for value look-up/storage in the form's value dictionary
	 * @param label
	 *            for display
	 * @param keyPath
	 *            path to the display value
	 * @param formatter
	 *            value transformer
	 * @param valueClass
	 *            class of the value value. A subclass of Value
	 * @param cssClass
	 *            CSS class to apply to the field
	 */
	public FormKeyPathValueFieldDescriptor(String key, String label,
			String keyPath, Format formatter, Class valueClass, String cssClass)
	{
		super(key, label, formatter, valueClass, cssClass);
		
		this.keyPath = keyPath;
	}
	
	
	
	/**
	 * Constructor
	 * 
	 * @param key
	 *            used for value look-up/storage in the form's value dictionary
	 * @param label
	 *            for display
	 * @param keyPath
	 *            path to the display value
	 * @param formatter
	 *            value transformer
	 */
	public FormKeyPathValueFieldDescriptor(String key, String label,
			String keyPath, Format formatter)
	{
		this(key, label, keyPath, formatter, null, null);
	}
	
	
	
	// Public instance methods
	
	/**
	 * Accessor method.
	 * 
	 * @return the keyPath used to access values
	 */
	public String keyPath()
	{
		return this.keyPath;
	}
	
	
	
	/**
	 * Transforms a value for display. The returned value is still subject to
	 * formatting as well as transformation by the value delegate.
	 * 
	 * @param value
	 * @return transformed value
	 */
	public Object displayValue(Object value)
	{
		String path = keyPath();
		
		if (path != null) {
			return KVCUtility.sharedInstance().valueForKeyPath(value, path);
		}
		
		return value;
	}
}
