/*
 * Copyright (C) 2007-2008 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package org.geometerplus.fbreader.bookmodel;

import java.util.*;
import org.geometerplus.zlibrary.core.util.*;

import org.geometerplus.zlibrary.text.model.ZLTextTreeModel;
import org.geometerplus.zlibrary.text.model.ZLTextTreeParagraph;
import org.geometerplus.zlibrary.text.model.impl.ZLTextTreeModelImpl;

public class ContentsModel extends ZLTextTreeModelImpl implements ZLTextTreeModel{
	private final HashMap myReferenceByParagraph = new HashMap();
	
	public int getReference(ZLTextTreeParagraph paragraph) {
		Integer num = (Integer)myReferenceByParagraph.get(paragraph);
		return (num != null) ? num.intValue() : -1;
	}
	
	public void setReference(ZLTextTreeParagraph paragraph, int reference) {
		myReferenceByParagraph.put(paragraph, reference);
	}
}
