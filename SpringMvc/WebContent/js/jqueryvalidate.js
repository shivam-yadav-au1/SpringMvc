// Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("#form").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      username: "required",
      address: "required",
      email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      phonenumber: {
        required: true,
        minlength: 10
      }
    },
    // Specify validation error messages
    messages: {
      username: "Please enter your username",
      address: "Please enter your address",
      phonenumber: {
        required: "Please provide a phonenumber",
        minlength: "Your phonenumber must be at least 10 digit"
      },
      email: "Please enter a valid email address"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});