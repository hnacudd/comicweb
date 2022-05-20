/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#formAU").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "title": {
                required: true,
            },
            "author": {
                required: true,
            },
            "publisher": {
                required: true,
            },
            "category":{
                required: true,
            },
            "content": {
                required: true,
            },
            "brief": {
                required: true,
            }
        },
        messages: {
            "title": {
                required: "Title can't empty",
            },
            "author": {
                required: "author can't empty",
            },
            "publisher": {
                required: "publisher can't empty",
            },
            "category":{
                required: "publisher can't empty",
            },
            "content": {
                required: "content can't empty",
            },
            "brief": {
                required: "brief can't empty",
            }
        },
        highlight: function (element) {
                $(element).parent().addClass('error')
            },
            unhighlight: function (element) {
                $(element).parent().removeClass('error')
            }
    });
});
