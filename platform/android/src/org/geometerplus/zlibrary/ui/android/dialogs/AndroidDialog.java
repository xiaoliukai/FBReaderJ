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
package org.geometerplus.zlibrary.ui.android.dialogs;

import android.app.Dialog;
import android.os.Handler;
import android.content.Context;
import android.view.*;

import org.geometerplus.zlibrary.ui.android.library.ZLAndroidLibrary;

final class AndroidDialog extends Dialog {
	private final View myView;
	private final String myCaption;
	private Runnable myCancelAction;
	private Runnable myExitAction;

	AndroidDialog(Context context, View view, String caption) {
		super(context);
		myView = view;
		myCaption = caption;
	}

	protected void onStart() {
		setContentView(myView);
		setTitle(myCaption);
	}

	protected void onStop() {
		if (myExitAction != null) {
			new Handler().post(myExitAction);
		}
		((ZLAndroidLibrary)ZLAndroidLibrary.getInstance()).getWidget().requestFocus();
	}

	public void setCancelAction(Runnable action) {
		myCancelAction = action;
	}

	public void setExitAction(Runnable action) {
		myExitAction = action;
	}

	public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && (myCancelAction != null)) {
			myCancelAction.run();
			return true;
		}
		return super.onKeyDown(keyCode, keyEvent);
	}
}
