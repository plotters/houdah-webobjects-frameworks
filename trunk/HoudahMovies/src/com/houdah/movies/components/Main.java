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

package com.houdah.movies.components;

import com.houdah.movies.application.Application;
import com.houdah.movies.application.Session;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSKeyValueCoding;

public class Main extends com.houdah.appserver.components.Page
{
	// Private class constants

	private static final long	serialVersionUID	= 2785766875610597965L;

	// Constructor

	public Main(WOContext context)
	{
		super(context);
	}

	// Accessor methods

	protected boolean needsBackTrackDetection()
	{
		return false;
	}


	protected NSKeyValueCoding list()
	{
		return new TaskActionProxy(Application.SEARCH_TASK);
	}

	protected NSKeyValueCoding insert()
	{
		return new TaskActionProxy(Application.EDIT_TASK);
	}

	// Inner class

	protected class TaskActionProxy implements NSKeyValueCoding
	{
		private String	task;

		public TaskActionProxy(String aTask) {
			this.task = aTask;
		}

		public Object valueForKey(String key)
		{
			Session session = (Session) session();
			WOComponent nextPage = session.pageWithEntityAndTask(key, this.task, context());

			return nextPage;
		}

		public void takeValueForKey(Object value, String key)
		{
			throw new IllegalAccessError("The proxy is not meant to be used this way!");
		}
	}
}