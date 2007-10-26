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

package com.houdah.web.view.table.descriptors;

import java.text.Format;

import com.houdah.web.view.actions.Action;
import com.houdah.web.view.constants.Alignment;
import com.houdah.web.view.table.cells.HVCTableColumnRowActionCell;

public class TableColumnRowActionDescriptor extends
		TableColumnRowTextDescriptor
{
	// Private instance variables
	
	private Action	controllerAction;
	
	
	
	
	// Constructor
	
	/**
	 * Designated constructor
	 * 
	 * @param controllerAction
	 *            descriptor of the controller action to call. NOT NULL
	 * @param keyPath
	 *            path to the field values. NOT NULL
	 * @param formatter
	 *            the formatter to apply
	 * @param escapeHTML
	 *            true if we should escape HTML in the displayed string
	 * @param alignment
	 *            alignment of data within the cell
	 * @param cssClass
	 *            CSS class to use for data cells
	 */
	public TableColumnRowActionDescriptor(Action controllerAction,
			String keyPath, Format formatter, boolean escapeHTML,
			Alignment alignment, String cssClass)
	{
		super(keyPath, formatter, escapeHTML, alignment, cssClass);
		
		this.controllerAction = controllerAction;
	}
	
	
	
	// Public instance methods
	
	/**
	 * @return Returns the descriptor of the controller action.
	 */
	public final Action controllerAction()
	{
		return this.controllerAction;
	}
	
	
	
	// Protected instance methods
	
	protected Class cellClass()
	{
		return HVCTableColumnRowActionCell.class;
	}
}