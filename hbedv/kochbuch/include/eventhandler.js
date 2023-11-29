// Onkey event 13 (Enter) fuer DefaultButton

var btn = null;

/****************************************************************************
 *
 ***************************************************************************/
function setDefaultButton(btn1) {
  if (btn1 != null) {
    document.onkeypress = keyhandler;
    btn = btn1;
  }
}

/****************************************************************************
 *
 ***************************************************************************/
function keyhandler(evt) {
  var Key = '';
  if (document.all) {
    Key += event.ctrlKey ? 'Ctrl-' : '';
    Key += event.altKey ? 'Alt-' : '';
    Key += event.shiftKey ? 'Shift-' : '';
    Key += event.keyCode;
  }
  else if (document.getElementById) {
    Key += evt.ctrlKey ? 'Ctrl-' : '';
    Key += evt.altKey ? 'Alt-' : '';
    Key += evt.shiftKey ? 'Shift-' : '';
    Key += evt.charCode;
  }
  else if (document.layers) {
    Key += evt.modifiers & Event.CONTROL_MASK ? 'Ctrl-' : '';
    Key += evt.modifiers & Event.ALT_MASK ? 'Alt-' : '';
    Key += evt.modifiers & Event.SHIFT_MASK ? 'Shift-' : '';
    Key += evt.which;
  }

  if (Key == 13 && window.document.activeElement.tagName != 'TEXTAREA') {
    if (parent.frames.length == 0) {
      //el = parent.document.getElementById(btn);
      el = document.getElementById(btn);
    } else {
      //el = parent.frames.body.document.getElementById(btn);
      el = document.getElementById(btn);
    }

    if (el == null) {
      alert("Button: " + btn + " not found");
    }  
    else {
        document.getElementById(btn).click();
    }
  }
  
  
}

