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

package com.houdah.eocontrol.qualifiers;

import java.util.StringTokenizer;

import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSKeyValueCodingAdditions;

/**
 * Superclass of custom qualifiers
 * 
 * @author bernard
 */
public abstract class Qualifier extends EOQualifier
{
	// Public class constants
	
	public static final String	KEY_PATH_SEPARATOR		= NSKeyValueCodingAdditions.KeyPathSeparator;
	
	public static final char	KEY_PATH_SEPARATOR_CHAR	= KEY_PATH_SEPARATOR
																.charAt(0);
	
	
	// supposes single character separator
	
	// Public class methods
	
	public static String allButLastPathComponent(String path) 
	{ 
		int i = path.lastIndexOf(KEY_PATH_SEPARATOR_CHAR); 

		return (i < 0) ? "" : path.substring(0, i); 
	} 
	
	
	public static String lastPathComponent(String path)
	{
		int i = path.lastIndexOf(KEY_PATH_SEPARATOR_CHAR);
		
		return (i < 0) ? path : path.substring(i + 1);
	}
	
	
	public static void validateKeyPathWithRootClassDescription(String keyPath,
			EOClassDescription classDescription)
	{
		StringTokenizer tokenizer = new StringTokenizer(keyPath,
				KEY_PATH_SEPARATOR);
		
		while (tokenizer.hasMoreElements()) {
			String key = tokenizer.nextToken();
			
			if (tokenizer.hasMoreElements()) {
				classDescription = classDescription
						.classDescriptionForDestinationKey(key);
				
				if (classDescription == null) {
					throw new IllegalStateException("Invalid key '" + key
							+ "' found");
				}
			} else {
				if (!classDescription.attributeKeys().containsObject(key)) {
					throw new IllegalStateException("Invalid key '" + key
							+ "' found");
				}
			}
		}
	}
}