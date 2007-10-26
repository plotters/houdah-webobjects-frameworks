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

package com.houdah.web.view.list.cells;



import com.houdah.web.view.components.Cell;
import com.houdah.web.view.list.descriptors.ListPropertyValueDescriptor;

import com.webobjects.appserver.WOContext;

public class ListPropertyValueCell extends Cell
{
	// Private class constants
	
	private static final long			serialVersionUID	= 2379761366676372936L;
	
	
	
	// Private instance variables
	
	
	/**
	 * Descriptor upon which to base the cell
	 */
	private ListPropertyValueDescriptor	cellDescriptor;
	
	
	
	/**
	 * Object to display in this cell
	 */
	private Object						displayedObject;
	
	
	
	
	// Constructor
	
	/**
	 * @param context
	 *            the context in which this component is instantiated
	 */
	public ListPropertyValueCell(WOContext context)
	{
		super(context);
	}
	
	
	
	// Public instance methods
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#awake()
	 */
	public void awake()
	{
		super.awake();
		
		this.cellDescriptor = (ListPropertyValueDescriptor) valueForBinding("cellDescriptor");
		this.displayedObject = valueForBinding("displayedObject");
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#reset()
	 */
	public void reset()
	{
		this.cellDescriptor = null;
		this.displayedObject = null;
		
		super.reset();
	}
	
	
	
	// Protected instance methods
	
	protected ListPropertyValueDescriptor cellDescriptor()
	{
		return this.cellDescriptor;
	}
	
	
	protected Object displayedObject()
	{
		return this.displayedObject;
	}
}