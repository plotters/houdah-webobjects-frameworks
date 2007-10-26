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

package com.houdah.web.view.simplelist;

import com.houdah.appserver.components.Element;
import com.houdah.web.view.simplelist.descriptors.SimpleListDescriptor;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

/**
 * A reusable component for displaying a plain list of items.
 * 
 */
public class HVCSimpleList extends Element
{
	// Private class constants
	
	private static final long		serialVersionUID	= -6038666539393555716L;
	
	
	
	// Public class constants
	
	// Private instance variables
	
	// API
	
	
	/**
	 * Array of objects to display. API, Needs to be bound.
	 */
	private NSArray					displayedObjects;
	
	
	
	/**
	 * A SimpleListDescriptor object. API, Needs to be bound.
	 */
	private SimpleListDescriptor	simpleListDescriptor;
	
	
	
	// Internal use
	
	/**
	 * Used internally for looping over items
	 */
	protected int					currentItemIndex;
	
	
	
	/**
	 * Used internally to cache the actual number of items displayed
	 */
	protected int					itemCount;
	
	
	
	
	// Constructor
	
	/**
	 * Designated constructor
	 * 
	 * @param context
	 *            the context in which this component is instantiated
	 */
	public HVCSimpleList(WOContext context)
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
		
		this.displayedObjects = (NSArray) valueForBinding("displayedObjects");
		this.simpleListDescriptor = (SimpleListDescriptor) valueForBinding("simpleListDescriptor");
		
		this.currentItemIndex = 0;
		this.itemCount = (this.displayedObjects != null) ? this.displayedObjects.count() : 0;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#reset()
	 */
	public void reset()
	{
		this.displayedObjects = null;
		this.simpleListDescriptor = null;
		
		this.currentItemIndex = 0;
		this.itemCount = 0;
		
		super.reset();
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#synchronizesVariablesWithBindings()
	 */
	public boolean synchronizesVariablesWithBindings()
	{
		return false;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#isStateless()
	 */
	public boolean isStateless()
	{
		return true;
	}
	
	
	
	// Protected instance methods
	
	/**
	 * Accessor method: Retrieves the object sbeing displayed
	 * 
	 * @return the objects being displayed
	 */
	protected NSArray displayedObjects()
	{
		return this.displayedObjects;
	}
	
	
	
	/**
	 * Accessor method: Retrieves the descriptor of the list
	 * 
	 * @return the descriptor of the list
	 */
	protected SimpleListDescriptor simpleListDescriptor()
	{
		return this.simpleListDescriptor;
	}
	
	
	
	/**
	 * Used internally. <br/>
	 * 
	 * @return the iteration item
	 */
	protected Object currentObject()
	{
		return displayedObjects().objectAtIndex(this.currentItemIndex);
	}
	
	
	
	/**
	 * Used internally. <br/> Called during the append-to-reponse phase to
	 * determine the CSS class to assign to the current row.
	 * 
	 * @return the CSS class name
	 */
	protected String itemClass()
	{
		String rowClass = (this.currentItemIndex % 2 == 0) ? "even" : "odd";
		
		return rowClass;
	}
	
	
	
	// Action methods
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.appserver.WOComponent#performParentAction(java.lang.String)
	 */
	public WOActionResults performParentAction(String actionName)
	{
		// Pushes the 'object' binding setting it to the current selection.
		// This is the object the controller actions should apply to.
		setValueForBinding(currentObject(), "object");
		
		return super.performParentAction(actionName);
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.houdah.generic.ViewComponent#performControllerAction(java.lang.String)
	 */
	public WOActionResults performControllerAction(String actionName)
	{
		// Pushes the 'object' binding setting it to the current selection.
		// This is the object the controller actions should apply to.
		setValueForBinding(currentObject(), "object");
		
		return super.performControllerAction(actionName);
	}
}