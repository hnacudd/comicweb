/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    var $form = $(".form-login");
    if ($form.length) {
        $form.validate({
            rules: {
                userName: {
                    required: true,

                },

                password: {
                    required: true,

                },
                rePassword: {
                    equalTo : "#password"
                }
            },
            messages: {
                userName: "Please enter your username",

                password: "Please enter your password",
                rePassword: "Please confirm your password"
            },
            highlight: function (element) {
                $(element).parent().addClass('error')
            },
            unhighlight: function (element) {
                $(element).parent().removeClass('error')
            }
        });
    }
});