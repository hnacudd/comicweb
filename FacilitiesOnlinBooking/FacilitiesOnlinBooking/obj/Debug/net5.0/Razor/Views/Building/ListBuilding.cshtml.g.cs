#pragma checksum "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "e495ac32e029273504f369127244d0a570b0bbbe"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Building_ListBuilding), @"mvc.1.0.view", @"/Views/Building/ListBuilding.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"e495ac32e029273504f369127244d0a570b0bbbe", @"/Views/Building/ListBuilding.cshtml")]
    public class Views_Building_ListBuilding : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<FacilitiesOnlinBooking.Model.Building>>
    {
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n\r\n");
#nullable restore
#line 4 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
   ViewData["Title"] = "ListBuilding";
    Layout = "~/Pages/Shared/_Layout.cshtml"; 

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "e495ac32e029273504f369127244d0a570b0bbbe3132", async() => {
                WriteLiteral(@"
    <style>
        #admin {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

            #admin td, #admin th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #admin tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            #admin tr:hover {
                background-color: #ddd;
            }

            #admin th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            }

        #student {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

            #student td, #student th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #student tr:nth-c");
                WriteLiteral(@"hild(even) {
                background-color: #f2f2f2;
            }

            #student tr:hover {
                background-color: #ddd;
            }

            #student th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 10px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
        }

            button:hover {
                opacity: 0.8;
            }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .normal {
            width: auto;
            padding: 10px 18px;
            background-color: Highlight;
        }
    </style>
");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "e495ac32e029273504f369127244d0a570b0bbbe6121", async() => {
                WriteLiteral("\r\n    <h1>GetListBuilding</h1>\r\n\r\n    <p>\r\n        ");
#nullable restore
#line 93 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
   Write(Html.ActionLink("Add", "AddBuilding", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
                WriteLiteral(" |\r\n    </p>\r\n    <table class=\"table\">\r\n        <thead>\r\n            <tr>\r\n                <th>\r\n                    ");
#nullable restore
#line 99 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
               Write(Html.DisplayNameFor(model => model.Id));

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n                </th>\r\n                <th>\r\n                    ");
#nullable restore
#line 102 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
               Write(Html.DisplayNameFor(model => model.name));

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n                </th>\r\n            </tr>\r\n        </thead>\r\n        <tbody>\r\n");
#nullable restore
#line 107 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
             foreach (var item in Model)
            {

#line default
#line hidden
#nullable disable
                WriteLiteral("                <tr>\r\n                    <td>\r\n                        ");
#nullable restore
#line 111 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
                   Write(Html.DisplayFor(modelItem => item.Id));

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 114 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
                   Write(Html.DisplayFor(modelItem => item.name));

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        <button class=\"normal\">\r\n                            ");
#nullable restore
#line 118 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
                       Write(Html.ActionLink("Edit", "UpdateBuiding", new { id = item.Id }));

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n                        </button>\r\n                        <form action=\"/Building/DeleteBuilding\" method=\"post\"><input type=\"text\" name=\"id\" style=\"display:none;\"");
                BeginWriteAttribute("value", " value=\"", 3278, "\"", 3294, 1);
#nullable restore
#line 120 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
WriteAttributeValue("", 3286, item.Id, 3286, 8, false);

#line default
#line hidden
#nullable disable
                EndWriteAttribute();
                WriteLiteral(" /><button class=\"normal\" type=\"submit\">Delete</button></form>\r\n                    </td>\r\n                </tr>\r\n");
#nullable restore
#line 123 "C:\Users\VACORN\OneDrive\Desktop\fob\FacilitiesOnlinBooking\FacilitiesOnlinBooking\Views\Building\ListBuilding.cshtml"
       }

#line default
#line hidden
#nullable disable
                WriteLiteral("        </tbody>\r\n    </table>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<FacilitiesOnlinBooking.Model.Building>> Html { get; private set; }
    }
}
#pragma warning restore 1591
