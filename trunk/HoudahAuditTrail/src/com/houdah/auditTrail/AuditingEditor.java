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

package com.houdah.auditTrail;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

public class AuditingEditor
{
	public boolean editorHasChangesForEditingContext(EOEditingContext context)
	{
		return context.updatedObjects().count() > 0;
	}
	
	
	public void editingContextWillSaveChanges(EOEditingContext context)
	{
		NSArray allObjects = context.registeredObjects();
		int count = allObjects.count();
		
		for (int i = 0; i < count; i++) {
			EOEnterpriseObject object = (EOEnterpriseObject) allObjects.objectAtIndex(i);
			
			if (object instanceof ChangeableRecord) {
				ChangeableRecord changeableRecord = (ChangeableRecord) object;
				NSDictionary changes = changeableRecord.changes();
				
				if (changes != null) {
					NSMutableDictionary mutableChanges = changes.mutableClone();
					
					// Do not trigger audit trail for changes to to-many relationships
					mutableChanges.removeObjectsForKeys(changeableRecord.toManyRelationshipKeys());
					
					if (mutableChanges.count() > 0) {
						changeableRecord.commitAuditTrail();
					} else {
						changeableRecord.purgeAuditTrail();
					}
				}
			}
		}
	}
}