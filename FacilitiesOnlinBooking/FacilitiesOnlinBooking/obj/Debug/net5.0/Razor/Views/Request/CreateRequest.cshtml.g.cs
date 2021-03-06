#pragma checksum "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "6c5a72f2466c02abc86b144b941983f7195bcc90"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Request_CreateRequest), @"mvc.1.0.view", @"/Views/Request/CreateRequest.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"6c5a72f2466c02abc86b144b941983f7195bcc90", @"/Views/Request/CreateRequest.cshtml")]
    public class Views_Request_CreateRequest : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
  
    ViewData["Title"] = "CreateRequest";
    Layout = "~/Pages/Shared/_Layout.cshtml";

#line default
#line hidden
#nullable disable
            WriteLiteral(@"
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

        button:hover {
            opacity: 0.8;
        }

    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    .container {
        padding: 16px;
    }

    span.psw {
        float: right;
        padding-top: 16px;
    }
</style>
<h1>CreateRequest</h1>
<form action=""CreateRequest"" method=""post"">

    <div class=""container"">
");
#nullable restore
#line 58 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
           List<SelectListItem> listBuilding = new List<SelectListItem>();

#line default
#line hidden
#nullable disable
#nullable restore
#line 59 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
           List<SelectListItem> listRoom = new List<SelectListItem>();

#line default
#line hidden
#nullable disable
#nullable restore
#line 60 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
         foreach (var item in Model.Building)
        {
            listBuilding.Add(new SelectListItem { Text = item.name, Value = Convert.ToString(item.Id) });
        }

#line default
#line hidden
#nullable disable
#nullable restore
#line 64 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
         foreach (var item in Model.Room)
        {
            listRoom.Add(new SelectListItem { Text = item.name, Value = Convert.ToString(item.Id) });
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("        ");
#nullable restore
#line 68 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
   Write(Html.DropDownList("Building", listBuilding));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n        ");
#nullable restore
#line 69 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
   Write(Html.DropDownList("Room", listRoom));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n        ");
#nullable restore
#line 70 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
   Write(Html.DropDownList("Slot", new List<SelectListItem>
        {
            new SelectListItem{ Text="Slot 1", Value = "1" },
            new SelectListItem{ Text="Slot 2", Value = "2" },
            new SelectListItem{ Text="Slot 3", Value = "3" },
            new SelectListItem{ Text="Slot 4", Value = "4" },
            new SelectListItem{ Text="Slot 5", Value = "5" },
            new SelectListItem{ Text="Slot 6", Value = "6" },
            new SelectListItem{ Text="Slot 7", Value = "7" },
            new SelectListItem{ Text="Slot 8", Value = "8" },
        }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n        <input type=\"datetime-local\" id=\"birthdaytime\" name=\"birthdaytime\"></br></br>\r\n        ");
#nullable restore
#line 82 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
   Write(Html.TextBox("Note"));

#line default
#line hidden
#nullable disable
            WriteLiteral(@"
        <div class=""container"" style=""background-color:#f1f1f1"">
            <button type=""submit"" class=""createButton"">Create</button>
            <span class=""psw""><a href=""/CreateRequest"">Create new request</a></span>
        </div>
    </div>

</form>

");
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n");
#nullable restore
#line 92 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Request\CreateRequest.cshtml"
      await Html.RenderPartialAsync("_ValidationScriptsPartial");

#line default
#line hidden
#nullable disable
            }
            );
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<dynamic> Html { get; private set; }
    }
}
#pragma warning restore 1591
