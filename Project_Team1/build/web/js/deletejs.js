/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function  isDelete() {
    var result = confirm("Want to delete?");
    if (result) {
        document.getElementById("formDelete").submit();
    }
}

