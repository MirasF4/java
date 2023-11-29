<!-- hide from silly old browsers
sAlertMessage = '';
sCheckedElements = '';

function checkForm(form, sErrorImagePath, sGoodImagePath, bCustomCheck){

  /* basic error checking for all forms

     created 9/28/99 by EHA
     modified 1/12/00 by EHA - cleaned up an error in the select box, refined custom error checking
     last modified 1/24/00 by EHA - added checkLength helper function (for use by custom code, primarily)

     form - object -the document.form object to be checked - required
     sErrorImagePath - string - the absolute or relative file path to an image indicating an incorrectly
        filled out item - optional
     sGoodImagePath - string -the absolute or relative file path to an image indicating an correctly filled
        out item, usually a clear gif - optional
     bCustomCheck - boolean - indicates if custom error checking is in use

     This error checking relies upon certain prefix "Keys" in the item names.
     keys in the form item name:
      req_ : required item
      mes_ : error message for item of the same name
      up_  : ignored.  Should NOT be present with mes_
      conf_: confirmation entry (for passwords for example)
    Any other prefixes in the form xxx_ will be ignored - see the StripKeys function for more details.

    SUMMARY:
    checkForm loops through the entire form which was submitted and looks for required elements.  All required
    elements are identified by the req_ key in the prefixing the form field name.  If a required element
    is found, then based on the type of that element, a specific error checking function is run. If you need to
    extend your error checking to cover special circumstances, pass "true" to checkForm in the bCustomCheck
    argument and see the section on custom error checking below.

    To use this error checking, add 'onSumbit="return checkForm(this, 'URL', 'URL', true)"' to your FORM tag.
    Somewhere in the HEAD element of your page add the line add a SCRIPT tag which includes the errorCheck.js
    file.

    STANDARD CHECK TYPES:
    Text types (password, text, textarea) are checked to make sure that they are greate than length 0, and that
    they contian at least one non-whitespace character.  Text types are also checked to see if they have a
    confirmation element.  Confirmation elements have the same base name, with a leading conf_ key.  Confirmation
    and primary elements must be identical to pass the check.

    Checkbox and Radio types are checked to make sure that at least one item in the array of items for that
    element is checked.

    Select types are checked to make sure that at least one option in the array for the element is selected, and that
    the selected option is NOT the first option in the list.  This error checking operates on the assumption that
    all select lists start with an instructional option such as "Please Select", which is not a valid selection. Any
    default options that are valid should NOT be the first option in the list.

    No other types are error checked. Hidden types passed through from a previous form will be ignored.  Any code
    passing items through from a previous form page should make a point not to pass any conf_ or mes_ items.

    SUPPLEMENTAL CHECK TYPES:
    Confirmation: Text types may also require that the user complete a confirmation (say for entering a password).
    The second, or confirmation box, has the same base name, with a leading conf_ key.  Confirmation and primary
    elements must be identical to pass the check.

    EMail: if the base part of the name contains the string "mail", and it is a text type, standard error checking
    will also check to see if it is a valid EMail address.


    WHEN AN ERROR IS FOUND:
    If an element does not pass the check, checkForm looks for an alert message, storred in a hidden item with the
    same base name, and a leading key mes_.  The value of this item should be the complete message to be displayed
    in the JavaScript alert box.  All messages are appended together, separated by the newline "\n" character, and
    displayed in a single alert box when the form is completely checked.

    If the path to an attention grabbing error image, and a neutral "good" image have been passed to checkForm, and
    the user's browser supports image swapping, checkForm will also place the attention grabbing image on the form.
    The name of the image must be the base name of the element, and there can only be one image with a given name
    per HTML page.

    Finally, checkForm tracks the first focusable element (types text and select) that had an error, and focuses the
    cursor on that element immediately before returning control to the browser.


    EXAMPLE:
    For example, the complete set of fields for password might look something like this:
    <input type="password" name="up_req_userpassword">
    <input type="password" name="conf_userpassword">
    <input type="hidden" name="mes_userpassword" value="Please make sure that you have entered a password, and typed exactly the same way again in the confirmation box.">

    the key up_ is used only by REGUSER - an ASP function.
    the key req_ is used by both REGUSER and this form checking routine.



    CUSTOM ERROR CHECKING:
    If you have a situation where you need some sort of custom login - if this field is true, then these two fields
    must be checked, but if that field is true, only the first of the two needs to be checked - or whatever, pass the
    value "true" to checkForm as the bCustomCheck argument, and create a function customCheck.  If this argument is
    true checkForm will execute the function customCheck as object-oriented JavaScript. checkForm will react to the
    properties of the oCustomCheck object.

    The arguments passed to customCheck are
      form - object - the form object passed to checkForm
      sGoodImagePath - string - the absolute, relative, or empty, path to the "good" image as passed to checkForm
      sErrorImagePath - string - the absolute, relative, or empty, path to the "error" image as passed to checkForm

    The properties returned by customCheck must be:
      pass - boolean - true if the form passed the custom error checking, false if it did not
      message - string - any message(s) to be displayed in the alert box, relating to the results of the custom error
            checking (only displayed if pass is false). Individual lines should be terminated by the JavaScript
            newline character "\n".

    CUSTOM CHECKING EXAMPLE:
    function customCheck(form, sErrorImagePath, sGoodImagePath) {
      // set variables and the properties of this object
      var bLocValid = true;
      var bSwapImage = false;
      this.pass = true;
      this.message = '';

      // presumably you know if you are using error images, but it's never a bad idea to check them anyway
      if (!document.images || sErrorImagePath == '' || sGoodImagePath == '' || !sErrorImagePath || !sGoodImagePath){
        bSwapImage = false;
      } else {
        bSwapImage = true;
      }

      if (form.req_LastName.value = 'Warner') {
        switch (form.req_FirstName.value) {
          case 'Yacko':
            bLocValid = false;
            this.message = this.message + 'No Warner Kids Allowed! \n';
            break;
          case 'Wacko':
            bLocValid = false;
            this.message = this.message + 'No Warner Kids Allowed! \n';
            break;
          case 'Dot':
            bLocValid = false;
            this.message = this.message + 'No Warner Kids Allowed! \n';
            this.message = this.message + 'You're cuuute. \n';
            break;
          default:
            break;
        }
      }

      if (!bLocValid && bSwapImage) {
        // put in the error image
        swapImage(form.WarnerKids, sErrorImagePath);
      } elseif (bSwapImage) {
        // don't leave an error image hanging around
        swapImage(form.WarnerKids, sGoodImagePath);
      }

      this.pass = bLocValid;

    }

  */




  // initialize the variables for this run of the function
  sAlertMessage = '';
  bReturn = true;
  iFocusElement = -1;
  sCheckedElements = '';
  bMessage = true;

  // check to see if image swapping is possible in this browser, or desired for this form
  // will not determine if the paths are valid
  if (!document.images || sErrorImagePath == '' || sGoodImagePath == '' || !sErrorImagePath || !sGoodImagePath){
    bSwapImage = false;
  } else {
    bSwapImage = true;
  }

  for (i=0; i < form.elements.length; i++){
    // store the form element in a new object to make life easier
    var item = form.elements[i]

    // fieldset ist ein element ohne name-Attribut -> fehler in javascript
    // darum wird es gesondert behandelt
    if (item.tagName != "FIELDSET") {
      // check to see if the item is required
      if (item.name.indexOf("req_") >= 0 ) {
        // find out what type of entry it is
        bErr = false;
        switch (item.type) {
          case 'button':
            // no error checking - should never get here
            break;
          case 'checkbox':
            if (!checkCheckbox(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'file':
            // no error checking
            break;
          case 'password':
            // error check, including check for the confirmation box
            // passwords are a special case of type Text, so use the same check mechanism
            if (!checkText(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            }

            // check the length of the password as well
            if (!checkLength(item, 6)){
              // add a semi-custom error message.
              sAlertMessage = sAlertMessage + 'Your password must be at least 6 characters long. \n';
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'radio':
            if (!checkCheckbox(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'reset':
            // no error checking - should never get here
            break;
          case 'select-one':
            if (!checkSelect(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'select-multiple':
            if (!checkSelect(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'submit':
            // no error checking - should never get here
            break;
          case 'hidden':
            // no error checking
            break;
          case 'text':
            // error check, including check for a confirmation box
            if (!checkText(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            } else {
              // check if we need special checks for Email Characters - always named "mail" after the user property
              if (stripKeys(item.name).toLowerCase() == 'mail') {
                if (!checkEmail(item)) {
                  addMessage(item, form);
                  // set the focus, if it has not already been set
                  if (iFocusElement == -1) {
                    iFocusElement = i;
                  }
                  bReturn = false;
                  bErr = true;
                }
              }
            }

            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          case 'textarea':
            // error check, including check for a confirmation box
            if (!checkText(item, form)) {
              // found a bad entry, add the error message, swap the image, set the over-all form value to bad
              addMessage(item, form);
              // set the focus, if it has not already been set
              if (iFocusElement == -1) {
                iFocusElement = i;
              }
              bReturn = false;
              bErr = true;
            }
            if (bSwapImage) {
              if (bErr) {
                // pop in the 'good' image, in case this is the second or third time around for this form
                swapImage(item, sGoodImagePath);
              } else {
                // pop in the error image
                swapImage(item, sErrorImagePath);
              }
            }

            break;
          default:
            // no error checking - should never get here
            break;
        }
      }
      else
      {
        if (item.type == "text" && item.name.indexOf("datum") >= 0 && item.value.length > 0) {
          if ( ! checkdateinc(item,form)) {
            //XBE Search
            // addMessage(item, form);
            // set the focus, if it has not already been set
            if (iFocusElement == -1) {
              iFocusElement = i;
            }
            bReturn = false;
            bErr = true;
			bMessage = false;
          }
        }
      }
    }
  }

  // look for and run any custom error checking routines
  if (bCustomCheck) {
    // make sure that the function really exists
    if (customCheck) {
      // run the custom check function, and test it's properties
      var oCustomCheck = new customCheck(form, sGoodImagePath, sErrorImagePath);
      if (!oCustomCheck.pass){
        // if the custum check routine found an error
        // set the overall error check to failure
        bReturn = false;
        // and add the custom message to the string
        sAlertMessage = sAlertMessage + oCustomCheck.message;
      }
    }
  }

  if (!bReturn && bMessage) {
    alert(sAlertMessage);
  }

  // set the focus in the form to the first focusable element, if one exists
  if (iFocusElement >= 0) {
    form.elements[iFocusElement].focus();
  }

  return bReturn;
}

// Primary Element Check Routines

function checkCheckbox(item, form) {
  // also used for radio buttons, since they behave the same way, and have the same properties

  /* Radio Buttons and Check boxes behave in an unusual manner.  When looping through the form
     element by element like this, each entry is its own entity with no relation to any others,
     even with the same name. Because we want to check the complete array of elements with the
     same name, we have to actually check the form by element name, rather than element number.
     To prevent duplicate checks, we will keep the names of all checked elements in a global
     string, and add each new name checked to the string.  If an item name is already in that
     string, it will not be checked again. */

  // set the local variables
  bLocValid = false;

  if (sCheckedElements.indexOf(item.name+',') < 0) {
    // hasn't been previously checked.  Add the name to the list and perform checks.
    sCheckedElements = sCheckedElements + item.name + ',';

    // because a checkbox could be one item, or many we first have to see if there is only one item and it is checked
    // if not, then we check to see if there are any items in the array that are checked
    if (eval('form.'+item.name+'.length')) {
      // loop through the individual memembers of the checkbox, looking for one that is checked (stop as soon as one is found)
      for (j=0; j < eval('form.'+item.name+'.length'); j++) {
        if (eval('form.'+item.name+'['+j+'].checked')){
          bLocValid = true;
          break;
        }
      }
    } else {
      // only one item
      if (item.checked) {
        bLocValid = true;
      }
    }
  } else {
    // has already been checked - return true.  Any false entries will have already been caught, and we don't want to give duplicate warnings.
    bLocValid = true;
  }

  return bLocValid;

}

function checkSelect(item) {
  /*
    Assumes that the first option item is NOT a valid if it has no defined value.  Note that JavaScript and the DOM descriminate
    between the VALUE and the TEXT of an option.  ASP makes the TEXT the VALUE when the form is posted, when no VALUE is set.
  */
  // set the local variables
  bLocValid = true;

  if (item.selectedIndex < 0) {
    // -1 is returned if NOTHING is selected (most common in IE 5 where no default selected option exists)
    bLocValid = false;
  }
  if (item.selectedIndex == 0) {
    // if the first item in the list does not have a value, it is not intended as a valid selection, but is probably instructional like "Choose One"

    if (item.options[0].value == '') {
      bLocValid = false;
    }
  }
  return bLocValid;
}

function checkText(item, form) {
  // set the local variables
  bLocValid = true;

  if (item.value.length < 1) {
    // is empty - no good
    bLocValid = false;
  } else {
    // check the value to make sure that it contains something other than white space characters
    // reset the valid value - this test will set it to positive only if it finds a good character
    bLocValid = false;
    // only check the first 100 characters at most - could result in a false negative, but hey,if they don't type a character in the first 100, is it REALLY a false negative?
    if (item.value.length < 100) {
      iLength = item.value.length;
    } else {
      iLength = 100;
    }

    for (j=0; j < iLength; j++) {
      sTemp = item.value.substring(j, j+1);
      if (sTemp != ' ' && sTemp != '\n' && sTemp != '\f' && sTemp != '\r' && sTemp != '\t') {
        bLocValid = true;
        break;
      }
    }
  }

  // see if you can figure out a way to do length constrains (max and min characters)


        // Datumsprüfung KLA !!!!!!!!!!
        if (bLocValid == true && item.name.indexOf("datum") >= 0) {
          if ( ! checkdateinc(item,form)) {
            bLocValid = false;
          }
        }

  if (bLocValid) {
    // check to see if a confirmation is required, and if it is valid
    if (!checkConfirm(item, form)) {
      bLocValid = false;
    }
  }

  return bLocValid;
}

// Secondary Element Check Routines

function checkConfirm(item, form) {
  // set  the local varaibles
  bConfirm = true;

  // look to see if there is a confirm field for the field being checked
  // if so, check to see that they are the same
  if (eval('form.conf_'+stripKeys(item.name))) {
    if (eval('form.conf_'+stripKeys(item.name)+'.value') != item.value) {
      bConfirm = false;
    }
  }

  return bConfirm;
}

function checkEmail (item) {
  // look for the required characters "@" & "." in the email value
  if (item.value.indexOf("@") < 0 || item.value.indexOf(".") < 0) {
    return false;
  } else {
    // be really picky and look at the positions of the "@" and the
    return true;
  }
}

function checkLength(item, iMin, iMax) {
  /* This routine is primarily for use by custom error checking, but is also in use by password.
     Can only be used on text-type items (text, textarea, password)
     If iMin is defined, checks for a minimum number of characters
     If iMax is defined, checks for a maximum number of characters
  */

  bLocValid = true;

  if (iMin && iMin != ''){
    if (item.value.length < iMin){
      bLocValid = false;
    }
  }
  if (iMax && iMax != ''){
    if (item.value.length > iMax){
      bLocValid = true;
    }
  }

  return bLocValid;
}

// KLA
function checkdateinc(item,Form)
{
 return ui_frameDatumCheck(item, "J");
}










// Helper Routines

function stripKeys(sTemp) {
  // strip out all the key values from a form element name
  // keys are xxxx_ eg req_ or up_
  sRet = sTemp.substring(sTemp.lastIndexOf("_")+1);

  return sRet;
}

function addMessage(item, form){
  // find the element of the form whose name is mes_NAME where NAME is the name of the field being checked, but w/ any key values
  // add it's value to the alert message
  sAlertMessage = sAlertMessage + eval('form.mes_'+stripKeys(item.name)+'.value') + '\n';
}

function swapImage(item, sSRC) {
  /* replace one image with another.  Generally a neutral or clear dot expanded to size with some sort of alerting or
     attention grabbing image. Expects to find the image named the same thing as the base portion of the form.element.name
     (no keys) which generated the error in the first place.  There can only be ONE image with each name on a page.
     (??? maybe user name.length??? like in checkCheckbox, if that really works ....???)
  */

  // check to see that the image is defined (not sure this will work - trying to avoid any error messages popping up)
  if (document[stripKeys(item.name)].src) {
    // swap the image
    document[stripKeys(item.name)].src = sSRC;
  }
}

// all done hiding -->
