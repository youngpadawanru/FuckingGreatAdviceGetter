// Generated code from Butter Knife. Do not modify!
package com.example.user.fuckinggreatadvicegetter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdviceAdapter$ViewHolder_ViewBinding implements Unbinder {
  private AdviceAdapter.ViewHolder target;

  @UiThread
  public AdviceAdapter$ViewHolder_ViewBinding(AdviceAdapter.ViewHolder target, View source) {
    this.target = target;

    target.advice_text = Utils.findRequiredViewAsType(source, R.id.advice_text, "field 'advice_text'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdviceAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.advice_text = null;
  }
}
