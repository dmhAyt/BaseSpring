/**
 * Created by deng_yt on 2018/8/24.
 */
var clickFolderIndex = 0;
var clickPath = false;
var nextFolderId = 0;
var nextFolderName = "next";
let folderId = 0;
let alterNameFolderId = -1;
let oldFolderName = null;
let indexPath = 0;
// 用来保存后端传过来的数据，用于当前页面的操作
var folderJsonData = null;
// 记录上一个右击过的文件 id
var folderDetailsId = null;
var folderPathArra = new Array();

$(document).ready(function () {
  // 异步请求，请求数据。
  sendAjax("folderContext.action", {"folderId": folderId}, "Content");
  $("#file").contextmenu(function () {
    return false;
  });
  $("#fileDetails").hide();
  $("#listOperateButton").hide();
  // $("#moveToOtherFolder").show();
});

$(window).on("load", function () {
  setTimeout(function () {
    $(".folderOperate").hide();
  });
});

/**
 * 将请求到的 json 数据加载到页面中。
 * @param json json 格式的数据
 */
function loadDataToView(json) {
  $("#file").empty();
  var jsons = null;
  debugger;
  for (var i = 0; i < json.length; i++) {
    jsons = json[i];
    // 这里要判断文件的格式，给指定的图标 。。。。。。。
    var fileImage = "icons8-folder.png";
    fileImage = judgmentImage(jsons.folderType);

    if ("FOLDER" === jsons.folderType) {

      $("<div></div>", {
        "class": "yt-img-over-around",
        style: {
          clear: "both"
        },
        html: "<input type='checkbox' name='listCheckbox' style='position: relative;top: 13px; z-index: 30;float: right'>",
        id: i
      }).appendTo($("#file"));

      $("<button></button>", {
        "class": "yt-img-button",
        type: "button"
      }).appendTo($("#" + i));

      $("<img/>", {
        "class": "yt-img-button-img",
        src: "../img/" + fileImage,
        alt: "file"
      }).appendTo($("#" + i + ">button"));

      $("<div></div>", {
        "class": "yt-img-texts",
        html: "<abbr class=\"yt-abbr\" title=\"" + jsons.folderName + "\">"
        + jsons.folderName + "</abbr>"
      }).appendTo($("#" + i));

      $("<div></div>", {
        "class": "folderOperate yt-img-oper",
        html: "<ul class=\"nav nav-pills nav-stacked\">"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"alterFolderName(this)\">重命名</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"showDetailsInfor(this)\">详细信息</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"deleteDataPre(this)\">删除数据</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"moveToOther(this)\">移动到...</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"newFolder(this,false)\">新建文件夹</a></li>"
        + "</ul>"
      }).appendTo($("#" + i));
    } else {
      $("<div></div>", {
        "class": "yt-img-over-around",
        html: "<input type='checkbox' name='listCheckbox' style=' z-index: 30;float: right'>",
        id: i
      }).appendTo($("#file"));

      $("<div></div>", {
        "class": "yt-img-button",
        type: "button"
      }).appendTo($("#" + i));

      $("<img/>", {
        "class": "yt-img-button-img",
        src: "../img/" + fileImage,
        alt: "file"
      }).appendTo($("#" + i + ">div:first"));

      $("<div></div>", {
        "class": "yt-img-texts",
        html: "<abbr class=\"yt-abbr\" title=\"" + jsons.folderName + "\">"
        + jsons.folderName + "</abbr>"
      }).appendTo($("#" + i));

      $("<div></div>", {
        "class": "folderOperate yt-img-oper",
        html: "<ul class=\"nav nav-pills nav-stacked\">"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"alterFolderName(this)\">重命名</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"showDetailsInfor(this)\">详细信息</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"deleteDataPre(this)\">删除数据</a></li>"
        + "<li role=\"presentation\"><a style=\"font-size: 12px;\" href=\"#\" onclick=\"moveToOther(this)\">移动到...</a></li>"
        + "</ul>"
      }).appendTo($("#" + i));
    }
  }
  // 设置一些监听
  $("input:checkbox").hide()
  $(".folderOperate").hide();
  $(".yt-img-over-around").hover(function () {
    $(".folderOperate").hide();
  });
  $(".yt-img-over-around").on("mouseup", function (e) {
    handler(this, e);
  });
  $("button.yt-img-button").click(function (e) {
    nextFolder(this);
  });
  loadFilePathToView();
}

/**
 * 判断文件类型的！什么类型使用什么图片
 */
function judgmentImage(folderType) {
  var imageName = "icons8-folder.png";
  if ("ZIP" === folderType) {
    imageName = "icons8-zip.png";
  } else if ("TXT" === folderType) {
    imageName = "icons8-txt.png";
  } else if ("DOC" === folderType) {
    imageName = "icons8-microsoft-word.png";
  }
  return imageName;
}
/**
 * 处理鼠标右击的事件 使用了 onclick() 进行了绑定。
 * @param element 所点击的 HTML
 * @param event   点击的事件
 */
function handler(element, event) {
  // 表示获得鼠标点击的类型 1 代表左键点击，2代表鼠标中间键点击，3代表鼠标右键点击
  if (event != null) {
    if (event.which === 3) {
      $(element).find(".folderOperate").show();
    }
  }
}
/**
 * 修改文件名的预处理
 * @param element
 */
function alterFolderName(element) {
  if (alterNameFolderId === -1) {
    $(".folderOperate").hide();
    var div = $(element).parent().parent().parent().parent();
    var id = $(div).attr("id");
    console.log(div);
    var divs = $("#" + id).find(".yt-img-texts");
    alterNameFolderId = parseInt(id);
    var oldFolderNames = folderJsonData[id].folderName.split(".");
    oldFolderName = oldFolderNames[0];
    $(divs).empty();
    $(divs).append(
        "<input id='alterInput' type=\"text\" style='height:15px;width: 60px;line-height: 15px' value=\""
        + oldFolderName
        + "\"/><p style='display: inline-block;line-height: 15px'>"
        + oldFolderNames[1] + "</p>");
    $("#alterInput").focus();
    $("#alterInput").blur(function () {
      alterFolderNameHandler();
    });
    $("#alterInput").keypress(function (data) {
      if (data.keyCode === 13) { // 13 为 回车键
        alterFolderNameHandler();
      }
    })
  }
}
/**
 * 显示文件的详细信息。
 * @param element 所点击元素的 id。
 */
function showDetailsInfor(element) {
  console.log($(element).parent().parent().parent().parent().attr("id"));
  var id = $(element).parent().parent().parent().parent().attr("id");
  if (id === folderDetailsId) {
    $("#fileDetails").hide();
    folderDetailsId = -1;
  } else {
    folderDetailsId = id;
    var date = new Date(folderJsonData[folderDetailsId].folderCreateDate);
    var size = "";
    if (folderJsonData[folderDetailsId].folderType != "FOLDER") {
      size = folderJsonData[folderDetailsId].folderSizes;
    }
    $("#fileDetails").show();
    $("#fileDetails").html("文件名:<br/>"
        + "&nbsp&nbsp " + folderJsonData[folderDetailsId].folderName + "<br/>"
        + "文件类型:<br/>"
        + "&nbsp&nbsp "
        + folderJsonData[folderDetailsId].folderType.toLowerCase() + "<br/>"
        + "创建时间:<br/>"
        + "&nbsp&nbsp " + folderJsonData[folderDetailsId].folderCreateDateStr
        + "<br/>"
        + "文件大小:<br/>"
        + "&nbsp&nbsp " + size + " <br/>");
  }

}
/**
 * 修改文件名的获得新名字，并判断是否需要更新。
 */
function alterFolderNameHandler() {
  var divs = $("#" + alterNameFolderId).find(".yt-img-texts");
  var newName = $("#alterInput").val();
  if (folderJsonData[alterNameFolderId].folderType === "FOLDER") {
    newName;
  } else {
    newName = newName + "."
        + folderJsonData[alterNameFolderId].folderName.split(".")[1];
  }
  if (newName != folderJsonData[alterNameFolderId].folderName) {
    sendAjax("alterFolderName.action", {
      "folderId": folderJsonData[alterNameFolderId].folderId,
      "folderName": newName
    }, "AlterFolderName");
  } else {
    $(divs).empty();
    $(divs).append("<abbr class=\"yt-abbr\" title=\""
        + folderJsonData[alterNameFolderId].folderName + "\">"
        + folderJsonData[alterNameFolderId].folderName + "</abbr>");
    alterNameFolderId = -1;
  }
}
/**
 * 与服务器进行交互。
 * @param path 交互的路径。只是后缀。
 * @param datas 交互发送的数据。
 * @param mark  标记，表示是哪个种处理。
 */
function sendAjax(path, datas, mark) {
  listOperate($(list), false);
  $.ajax({
    url: "http://localhost:8080/" + path,
    type: "POST",
    data: JSON.stringify(datas),
    contentType: 'application/json',
    success: function (json) {
      if (mark === "Content") {
        if (!clickPath) {
          if (folderId != 0) {
            clickFolderIndex = parseInt(clickFolderIndex);
            folderPathArra[indexPath++] = new Folder(folderJsonData[clickFolderIndex].folderId, folderJsonData[clickFolderIndex].folderName);
          } else {
            folderPathArra[indexPath++] = new Folder(0, "Home");
          }
        }
        folderJsonData = json;
        loadDataToView(json);
      } else if (mark === "AlterFolderName") {
        var divs = $("#" + alterNameFolderId).find(".yt-img-texts");
        folderJsonData[alterNameFolderId].folderName = json.folderName;
        $(divs).empty();
        $(divs).append("<abbr class=\"yt-abbr\" title=\""
            + json.folderName + "\">"
            + json.folderName + "</abbr>");
        alterNameFolderId = -1;
        alert("修改成功！");
      } else if ("DeleteFolder" === mark) {
        // 假刷新界面
        sendAjax("folderContext.action", {"folderId": folderId}, "Content");
        alterNameFolderId = -1;
        alert("删除成功！");
      } else if ("newFolder" === mark) {
        sendAjax("folderContext.action", {"folderId": folderId}, "Content");
        alterNameFolderId = -1;
        alert("新建成功！");
      }
    },
    error: function (json) {
      alterNameFolderId = -1;
      console.log("fail");
      console.log(json.toString());
      var divs = $("#" + alterNameFolderId).find(".yt-img-texts");
      if (mark === "AlterFolderName") {
        $(divs).empty();
        $(divs).append("<abbr class=\"yt-abbr\" title=\""
            + folderJsonData[alterNameFolderId].folderName + "\">"
            + folderJsonData[alterNameFolderId].folderName + "</abbr>");
      }
    },
    dataType: "json"

  });
}
/**
 * 删除数据的预处理
 * @param element
 */
function deleteDataPre(element) {
  // 显示模态框
  var div = $(element).parent().parent().parent().parent();
  var id = $(div).attr("id");
  $("#modal").modal("show");
  $("#modal").find(".modal-footer").attr("id", "footer." + id);
}
/**
 * 删除操作
 * @param element
 */
function deleteDateOperate(element) {
  $("#modal").modal("hide");
  var str = $(element).parent().attr("id").split(".");
  sendAjax("deleteFolder.action", {"folderId": folderJsonData[str[1]].folderId},
      "DeleteFolder");
}
/**
 * 点击进入文件夹
 * @param element
 */
function nextFolder(element) {
  if (element != null) {
    $("#fileDetails").hide();
    alterNameFolderId = -1;
    clickPath = false;
    var id = $(element).parent().attr("id");
    if (id != null) {
      clickFolderIndex = id;
      id = folderJsonData[id].folderId;
      if (id != folderId) {
        folderId = id;
        sendAjax("folderContext.action", {"folderId": folderId}, "Content");
      }
    }
  }
}
/**
 * 加载路径导航
 */
function loadFilePathToView() {
  $("#file-path-head").empty();
  for (var i = 0; i < folderPathArra.length; i++) {
    if (folderPathArra.length - 1 === i) {
      $("#file-path-head").append(
          "<li class=\"active\" >" + folderPathArra[i].folderName + "</li>");
    } else {
      $("#file-path-head").append(
          " <li id=\"path." + i + "\"><a href=\"#\" onclick='pathClick(this)'>"
          + folderPathArra[i].folderName + "</a></li>");
    }
  }

}
/**
 * 点击路径导航数据，返回
 * @param element
 */
function pathClick(element) {
  var id = $(element).parent().attr("id");
  $("#fileDetails").hide();
  alterNameFolderId = -1;
  clickPath = true;
  id = id.split(".")[1];
  indexPath = parseInt(id) + 1;
  var ids = folderPathArra[id].folderId;
  folderPathArra.splice((id), folderPathArra.length - id, folderPathArra[id]);
  if (ids != folderId) {
    folderId = ids;
    sendAjax("folderContext.action", {"folderId": folderId}, "Content");
  }
}
/**
 * 路径存储。
 */
class Folder {
  constructor(x, y) {
    this.folderId = x;
    this.folderName = y;
  }

  toString() {
    return '(' + this.folderId + ', ' + this.folderName + ')';
  }
}
/**
 * 新建文件名：
 * @param element 被点击的元素
 * @param current 是否是在当前目录下新建
 */
function newFolder(element, current) {
  var subFolderId = 0;
  var folderName = prompt("文件夹名");
  // 是在当前文件夹中建立新的文件夹
  if (folderName != null) {
    if (current) {
      subFolderId = folderId;
    } else {
      var div = $(element).parent().parent().parent().parent();
      subFolderId = folderJsonData[$(div).attr("id")].folderId;
    }
    // 进行调用 ajax 传送数据
    sendAjax("newFolder.action",
        {folderSuperiorId: subFolderId, folderName: folderName}, "newFolder");
  }
}
/**
 * 批量选择，批量操作
 * @param element 被点击的元素
 * @param flage 表示是否是显示还是关闭
 */
function listOperate(element, flage) {
  if (flage) {
    // 显示
    $(element).text("");
    $(element).text("取消批量操作");
    $(element).attr("onclick", "listOperate(this,false)");
    $("input:checkbox").show();
    $("#listOperateButton").show();
  } else {
    $(element).text("");
    $(element).text("批量操作");
    $(element).attr("onclick", "listOperate(this,true)");
    $("input:checkbox").hide();
    $("#listOperateButton").hide();
    $("input:checkbox").attr("checked", false);
  }

}

function download(element) {

}
/**
 * 批量删除文件
 * @param element 被点击的元素
 */
function deleteList(element) {
  var check = $("input:checkbox");
  var index = 0;
  var folderIdArray = [];
  $.each(check, function (i) {
    if (check[i].checked) {
      folderIdArray[index++] = {
        folderId: folderJsonData[$(check[i]).parent().attr("id")].folderId
      };
    }
  });
  if (folderIdArray != null && folderIdArray.length > 0) {
    // 发送数据进行删除操作
    sendAjax("deleteList.action", folderIdArray, "DeleteFolder");
  }
  console.log(folderIdArray);
}
/**
 * 移动到别的文件夹
 * @param element 被点击元素
 */
function moveToOther(element) {
  // 显示弹出框。
  $("#moveToOtherFolders").modal("show");
  // $("#moveToOtherFolders").modal("show");
}
