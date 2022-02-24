$(document).ready(function() {
   //csrf
   var token = $("meta[name='_csrf']").attr("content");
   var header = $("meta[name='_csrf_header']").attr("content");
   if(token && header){
      $(function() {
          $(document).ajaxSend(function(e, xhr, options) {
              xhr.setRequestHeader(header, token);
          });
      });
   };   

   $("#option-add-btn").off('click').on('click',function(){
        $("#addSetting").appendTo("body").modal('show');
    });
   

        $(".client").show();
        $(".institute").hide();
        $(".spot").hide();
        $(".occupation").hide();
        $(".task").hide();
        $(".area").hide();
        $(".qualifi").hide();
        $("#option-save-btn").removeAttr("onclick");
        $("#option-save-btn").attr("onclick", "clientAdd()");
        $("#option-update-btn").removeAttr("onclick");
        $("#option-update-btn").attr("onclick", "clientUpdate()");

        
        $(".nav-item1").click(function() {
            idx = $(this).index();

            // 근무경력
            if(idx == '0'){
                $(".client").show();
                $(".institute").hide();
                $(".spot").hide();
                $(".occupation").hide();
                $(".task").hide();
                $(".area").hide();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "clientAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "clientUpdate()");
            }
            else if(idx == '1'){
                $(".client").hide();
                $(".institute").show();
                $(".spot").hide();
                $(".occupation").hide();
                $(".task").hide();
                $(".area").hide();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "instituteAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "instituteUpdate()");
            }
            else if(idx == '2'){
                $(".client").hide();
                $(".institute").hide();
                $(".spot").show();
                $(".occupation").hide();
                $(".task").hide();
                $(".area").hide();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "spotAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "spotUpdate()");
            }
            else if(idx == '3'){
                $(".client").hide();
                $(".institute").hide();
                $(".spot").hide();
                $(".occupation").show();
                $(".task").hide();
                $(".area").hide();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "occupationAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "occupationUpdate()");
            }
            else if(idx == '4'){
                $(".client").hide();
                $(".institute").hide();
                $(".spot").hide();
                $(".occupation").hide();
                $(".task").show();
                $(".area").hide();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "taskAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "taskUpdate()");
            }
            else if(idx == '5'){
                $(".client").hide();
                $(".institute").hide();
                $(".spot").hide();
                $(".occupation").hide();
                $(".task").hide();
                $(".area").show();
                $(".qualifi").hide();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "areaAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "areaUpdate()");
            }
            else if(idx == '6'){
                $(".client").hide();
                $(".institute").hide();
                $(".spot").hide();
                $(".occupation").hide();
                $(".task").hide();
                $(".area").hide();
                $(".qualifi").show();
                $("#option-save-btn").removeAttr("onclick");
                $("#option-save-btn").attr("onclick", "qualifiAdd()");
                $("#option-update-btn").removeAttr("onclick");
                $("#option-update-btn").attr("onclick", "qualifiUpdate()");
            }
        });
    var rowId;
    var data;
    var seldata;

    //고객사
    jQuery("#clientList").jqGrid({
        url:'ClientList',
        datatype: 'json',
        mtype:'POST',
        editurl: 'ClientEdit',
        colNames:['','nm','이름'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'client_nm', index:'client_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: jQuery('#clientListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'client_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "고객사",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "client_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#clientList').jqGrid('getGridParam', 'selrow');
                    var client_nm = $('#clientList').jqGrid('getRowData',rowId).client_nm;
                    var name = $('#clientList').jqGrid('getRowData',rowId).name;
                    $("#update_client_name").val(name);
                    $("#update_client_nm").val(client_nm);
                    console.log(client_nm);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {
                    
                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#clientList") .jqGrid({
                    pager : '#clientListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });  
        

    //직무
    jQuery("#taskList").jqGrid({
        url:'TaskList',
        datatype: 'json',
        mtype:'POST',
        editurl: "TaskEdit",
        colNames:['','nm','이름', '상위코드'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'task_nm', index:'task_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}},

            {name:'occupation', index:'occupation',  width:100,align:"center", hidden: true,
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: jQuery('#taskListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'task_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "업무",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "task_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#taskList').jqGrid('getGridParam', 'selrow');
                    var occupation = $('#taskList').jqGrid('getRowData',rowId).occupation;
                    var task_nm = $('#taskList').jqGrid('getRowData',rowId).task_nm;
                    var name = $('#taskList').jqGrid('getRowData',rowId).name;
                    console.log(task_nm);
                    $("#update_occupation option").filter(function(){return this.value == occupation;}).attr('selected',true);
                    $("#update_task_name").val(name);
                    $("#update_task_nm").val(task_nm);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {
                    
                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#taskList") .jqGrid({
                    pager : '#taskListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });  
        
    

    //학원
    jQuery("#instituteList").jqGrid({
        url:'InstituteList',
        datatype: 'json',
        mtype:'POST',
        editurl: 'InstituteEdit',
        colNames:['','ID','이름'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'institute_nm', index:'institute_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
            ],

                pager: jQuery('#instituteListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'institute_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "학원",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "institute_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#instituteList').jqGrid('getGridParam', 'selrow');
                    var institute_nm = $('#instituteList').jqGrid('getRowData',rowId).institute_nm;
                    var name = $('#instituteList').jqGrid('getRowData',rowId).name;
                    $("#update_institute_name").val(name);
                    $("#update_institute_nm").val(institute_nm);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {

                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#instituteList") .jqGrid({
                    pager : '#instituteListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });  

    //직종
    jQuery("#occupationList").jqGrid({
        url:'OccupationList',
        datatype: 'json',
        mtype:'POST',
        editurl: "OccupationEdit",
        colNames:['','nm','이름'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'occupation_nm', index:'occupation_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: jQuery('#occupationListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'occupation_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "업무",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "occupation_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#occupationList').jqGrid('getGridParam', 'selrow');
                    var occupation_nm = $('#occupationList').jqGrid('getRowData',rowId).occupation_nm;
                    var name = $('#occupationList').jqGrid('getRowData',rowId).name;
                    $("#update_occupation_name").val(name);
                    $("#update_occupation_nm").val(occupation_nm);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {
                    
                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#occupationList") .jqGrid({
                    pager : '#occupationListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });  


    //직위
    jQuery("#spotList").jqGrid({
        url:'SpotList',
        datatype: 'json',
        mtype:'POST',
        editurl: 'SpotEdit',
        colNames:['','ID','이름'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'spot_nm', index:'spot_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
            ],

                pager: jQuery('#spotListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'spot_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "직무",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "spot_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#spotList').jqGrid('getGridParam', 'selrow');
                    var spot_nm = $('#spotList').jqGrid('getRowData',rowId).spot_nm;
                    var name = $('#spotList').jqGrid('getRowData',rowId).name;
                    $("#update_spot_name").val(name);
                    $("#update_spot_nm").val(spot_nm);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {

                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#spotList") .jqGrid({
                    pager : '#spotListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });


    //지역
    jQuery("#areaList").jqGrid({
        url:'AreaList',
        datatype: 'json',
        mtype:'POST',
        editurl: 'AreaEdit',
        colNames:['','ID','이름'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'id', index:'id',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'name', index:'name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
            ],

                pager: jQuery('#areaListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'id',
                viewrecords: true,
                sortorder: "desc",
                caption: "지역",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "id"
                },
                ondblClickRow: function(){
                    rowId = $('#areaList').jqGrid('getGridParam', 'selrow');
                    var id = $('#areaList').jqGrid('getRowData',rowId).id;
                    var name = $('#areaList').jqGrid('getRowData',rowId).name;
                    $("#update_area_name").val(name);
                    $("#update_id").val(id);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {

                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#areaList") .jqGrid({
                    pager : '#areaListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });
        
    //자격증
    jQuery("#qualifiList").jqGrid({
        url:'qualificatonCodeList',
        postdata : '',
        datatype: 'json',
        mtype:'POST',
        editurl: 'qualificatonCodeEdit',
        colNames:['','ID','이름','발급기관'],
        colModel:[
            { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true}},

            {name:'qualifi_nm', index:'qualifi_nm',  width:50,align:"center",
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

            {name:'qualifi_name', index:'qualifi_name',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}},

            {name:'issuer', index:'issuer',  width:100,align:"center",
                editrules:{  required:true,edithidden:true },editable:true,
                editoptions:{size:"50",maxlength:"50"}}
            ],

                pager: jQuery('#qualifiListPager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortname: 'qualifi_nm',
                viewrecords: true,
                sortorder: "desc",
                caption: "지역",
                width : 900,
                height :'auto',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "qualifi_nm"
                },
                ondblClickRow: function(){
                    rowId = $('#qualifiList').jqGrid('getGridParam', 'selrow');
                    var qualifi_nm = $('#qualifiList').jqGrid('getRowData',rowId).qualifi_nm;
                    var qualifi_name = $('#qualifiList').jqGrid('getRowData',rowId).qualifi_name;
                    var issuer = $('#qualifiList').jqGrid('getRowData',rowId).issuer;
                    $("#update_qualifi_name").val(qualifi_name);
                    $("#update_qualifi_nm").val(qualifi_nm);
                    $("#update_qualifi_issuer").val(issuer);
                    $("#updateSetting").appendTo("body").modal('show');
                },
                onSelectRow: function() {

                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
                });

                jQuery("#qualifiList") .jqGrid({
                    pager : '#qualifiListPager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });
});//document.ready 끝


//고객사추가
function clientAdd(){
    var clientparam = $("form[name=clientForm]").serialize();
    var client_name = $("#client_name").val();
    if(client_name==""){
        alert("고객사를 입력해주세요");
        $("#client_name").focus();
        return;
    }

    $.ajax({  
      type: "POST" ,
      url: "/ClientAdd",
      data: clientparam,
      success:function(data){
        SettingReset("client");
        $("#addSetting").modal("hide");
        $("#clientList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

// 직종추가
function occupationAdd(){
  var occupationparam = $("form[name=occupationForm]").serialize();
  var occupation_name = $("#occupation_name").val();
  if(occupation_name==""){
      alert("직종을 입력해주세요");
      $("#occupation_name").focus();
      return;
  }

  $.ajax({  
    type: "POST" ,
    url: "/OccupationAdd",
    data: occupationparam,
    success:function(data){
      SettingReset("occupation");
      $("#addSetting").modal("hide");
      $("#occupationList").trigger("reloadGrid");
    },
    error:function(data){
      alert("error");
    }
});
}

// 직무추가
function taskAdd(){
    var taskparam = $("form[name=taskForm]").serialize();
    var upper_task_nm = $("#upper_task_nm").val();
    var task_name = $("#task_name").val();
    if(upper_task_nm==""){
        alert("직종을 선택해주세요");
        $("#upper_task_nm").focus();
        return;
    }
    if(task_name==""){
        alert("직무를 입력해주세요");
        $("#task_name").focus();
        return;
    }

    $.ajax({  
      type: "POST" ,
      url: "/TaskAdd",
      data: taskparam,
      success:function(data){
        SettingReset("task");
        $("#addSetting").modal("hide");
        $("#taskList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

// 학원추가
function instituteAdd(){
    var instituteparam = $("form[name=instituteForm]").serialize();
    var institute_name = $("#institute_name").val();
    if(institute_name==""){
        alert("교육기관을 입력해주세요");
        $("#institute_name").focus();
        return;
    }

    $.ajax({  
      type: "POST" ,
      url: "/InstituteAdd",
      data: instituteparam,
      success:function(data){
        SettingReset("institute");
        $("#addSetting").modal("hide");
        $("#instituteList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

// 직무추가
function spotAdd(){
    var spotparam = $("form[name=spotForm]").serialize();
    var spot_name = $("#spot_name").val();
    if(spot_name==""){
        alert("직위를 입력해주세요");
        $("#spot_name").focus();
        return;
    }
    
    $.ajax({  
      type: "POST" ,
      url: "/SpotAdd",
      data: spotparam,
      success:function(data){
        SettingReset("spot");
        $("#addSetting").modal("hide");
        $("#spotList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}
// 지역추가
function areaAdd(){
  var spotparam = $("form[name=areaForm]").serialize();
  var arae_name = $("#arae_name").val();
  if(arae_name==""){
      alert("지역을 입력해주세요");
      $("#arae_name").focus();
      return;
  }
  $.ajax({  
    type: "POST" ,
    url: "/AreaAdd",
    data: spotparam,
    success:function(data){
      SettingReset("area");
      $("#addSetting").modal("hide");
      $("#areaList").trigger("reloadGrid");
    },
    error:function(data){
      alert("error");
    }
  });
}
// 자격증추가
function qualifiAdd(){
  var spotparam = $("form[name=qualifiForm]").serialize();
  var qualifi_name = $("#qualifi_name").val();
  var qualifi_issuer = $("#qualifi_issuer").val();
  if(qualifi_name==""){
      alert("자격증을 입력해주세요");
      $("#qualifi_name").focus();
      return;
  }
  if(qualifi_issuer==""){
      alert("발행기관을 입력해주세요");
      $("#qualifi_issuer").focus();
      return;
  }
  $.ajax({  
    type: "POST" ,
    url: "/qualificatonCodeAdd",
    data: spotparam,
    success:function(data){
      SettingReset("qualifi");
      $("#addSetting").modal("hide");
      $("#qualifiList").trigger("reloadGrid");
    },
    error:function(data){
      alert("error");
    }
});
}


//고객사 수정
function clientUpdate(){
    var clientUpdateForm = $("form[name=clientUpdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/ClientUpdate",
        data: clientUpdateForm,
        success:function(data){
          $("#updateSetting").modal("hide");
          $("#clientList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

// 직종 수정
function occupationUpdate(){
  var occupationUpdateForm = $("form[name=occupationUpdateForm]").serialize();

  $.ajax({  
      type: "POST" ,
      url: "/OccupationUpdate",
      data: occupationUpdateForm,
      success:function(data){
        $("#updateSetting").modal("hide");
        $("#occupationList").trigger("reloadGrid");
          alert('수정되었습니다.');
      },
      error:function(data){
      alert("error");
      }
  });
}

// 직무 수정
function taskUpdate(){
    var taskUpdateForm = $("form[name=taskUpdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/TaskUpdate",
        data: taskUpdateForm,
        success:function(data){
          $("#updateSetting").modal("hide");
          $("#taskList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

// 학원 수정
function instituteUpdate(){
    var instituteUpdateForm = $("form[name=instituteUpdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/InstituteUpdate",
        data: instituteUpdateForm,
        success:function(data){
          $("#updateSetting").modal("hide");
          $("#instituteList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

// 직무 수정
function spotUpdate(){
    var spotUpdateForm = $("form[name=spotUpdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/SpotUpdate",
        data: spotUpdateForm,
        success:function(data){
          $("#updateSetting").modal("hide");
          $("#spotList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}
// 지역 수정
function areaUpdate(){
  var areaUpdateForm = $("form[name=areaUpdateForm]").serialize();

  $.ajax({  
      type: "POST" ,
      url: "/AreaUpdate",
      data: areaUpdateForm,
      success:function(data){
        $("#updateSetting").modal("hide");
        $("#areaList").trigger("reloadGrid");
          alert('수정되었습니다.');
      },
      error:function(data){
      alert("error");
      }
  });
}
// 자격증 수정
function qualifiUpdate(){
  var qualifiUpdateForm = $("form[name=qualifiUpdateForm]").serialize();

  $.ajax({  
      type: "POST" ,
      url: "/qualificatonCodeUpdate",
      data: qualifiUpdateForm,
      success:function(data){
        $("#updateSetting").modal("hide");
        $("#qualifiList").trigger("reloadGrid");
          alert('수정되었습니다.');
      },
      error:function(data){
      alert("error");
      }
  });
}