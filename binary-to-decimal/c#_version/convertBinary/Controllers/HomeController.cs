using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using convertBinary.Models;
namespace convertBinary.Controllers;

public class HomeController : Controller
{
    public IActionResult Index()
    {
        return View("html_css_and_javascript");
    }
    
    [Route("convert-number")]
    [HttpPost]
    public IActionResult Post([FromBody] RequestModel jsonData)
    {     
        string value = jsonData.Value;
        string valueIn = jsonData.ValueIn;
        string convertIn = jsonData.ConvertIn;
        int cont = 0;
        int result = 0;
        int powValue = 0;

        for(int i = value.Length - 1; i >= 0; i--) {
            powValue = (int) Math.Pow(2, cont);
            result = result + (powValue * (value[i] - '0'));
            cont++;
        }
        return Ok(result);
    }
}
