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
	
	var asd = {  }
	
    //상세페이지 내에서 추가버튼 클릭시 중복 생성 방지
    $("#detail-add-btn").off('click').on('click',function(){
        $("#addDetials").appendTo("body").modal('show');
    });

    $(document).on("keyup", "#phone", function() { 
        $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
    });
    

    //버튼 클릭시 검색창 변경
    $(".nav-item").click(function() {
        var idx = $(this).index();
        if(idx == '0'){
            $("#pdf-btn").show();
            $("#update-btn").show();
            $("#detail-add-btn").hide();
        }else{
            $("#pdf-btn").hide();
            $("#update-btn").hide();
            $("#detail-add-btn").show();
        }

        // 근무경력
        if(idx == '1'){
            $("#workList").trigger("reloadGrid");
            $(".work").show();
            $(".career").hide();
            $(".education").hide();
            $(".edumatter").hide();
            $(".qualifications").hide();
            $(".prize").hide();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "workAdd()");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "workUpdate()");
        }
        // 기술경력
        else if(idx == '2'){
            $("#careerList").trigger("reloadGrid");
            $(".work").hide();
            $(".career").show();
            $(".education").hide();
            $(".edumatter").hide();
            $(".qualifications").hide();
            $(".prize").hide();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "careerAdd();");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "careerUpdate()");
        }
        // 학력사항
        else if(idx == '3'){
            $("#educationList").trigger("reloadGrid");
            $(".work").hide();
            $(".career").hide();
            $(".education").show();
            $(".edumatter").hide();
            $(".qualifications").hide();
            $(".prize").hide();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "educationAdd ();");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "educationUpdate()");
        }
        //교육사항
        else if(idx == '4'){
            $("#edumatterList").trigger("reloadGrid");
            $(".work").hide();
            $(".career").hide();
            $(".education").hide();
            $(".edumatter").show();
            $(".qualifications").hide();
            $(".prize").hide();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "edumatterAdd();");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "edumatterUpdate()");
        }
        //자격증
        else if(idx == '5'){
            $("#qualificationsList").trigger("reloadGrid");
            $(".work").hide();
            $(".career").hide();
            $(".education").hide();
            $(".edumatter").hide();
            $(".qualifications").show();
            $(".prize").hide();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "qualificationsAdd();");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "qualificationsUpdate()");
        }
        //상훈
        else if(idx == '6'){
            $("#prizeList").trigger("reloadGrid");
            $(".work").hide();
            $(".career").hide();
            $(".education").hide();
            $(".edumatter").hide();
            $(".qualifications").hide();
            $(".prize").show();
            $("#detail-save-btn").removeAttr("onclick");
            $("#detail-save-btn").attr("onclick", "prizeAdd();");
            $("#detail-update-btn").removeAttr("onclick");
            $("#detail-update-btn").attr("onclick", "prizeUpdate()");
        }

    })



    var link_id =$('#info_id').val();
    console.log(link_id);
    
    //기술경력
    //jqGrid 부분
    $("#careerList").jqGrid({
        url:'detail/CareerList',
        datatype: 'json',
        mtype:'POST',
        editurl: '/detail/CareerEdit',
        colNames:['','','','사업명','사업기간','고객사','직종/직무','직종','직무'],
        colModel:[
                { name: 'myac', width: 30, fixed:true, sortable : false, formatter:'actions',align:"center", 
                formatoptions:{ editbutton : false, delbutton:true}},

                {name:'id',  index:'id', sortable : false, width:20, align:"center", hidden: true,
                editrules:{  readonly:true, edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

                {name:'info_id', index:'info_id', sortable : false, width:20, align:"center", hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50",defaultValue:link_id}},

                {name:'project_name', index:'project_name', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'date', index:'date', sortable : false, width:110, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'client_name', index:'client_name', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'task_occupation', index:'task_occupation', sortable : false, width:80, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
                
                {name:'occupation', index:'occupation', sortable : false, width:80, align:"center",hidden: true,
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'task', index:'task', sortable : false, width:80, align:"center",hidden: true,
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}}                    
                
        ],

        

                pager: $('#careerListPager'),
                pagination:true,
                shrinkToFit:false,
                sortname: 'id',
                viewrecords: true,
                sortorder: "desc",
                caption: "기술경력",
                width :"900",
                height :'221',
                rowNum:10,
                rowList:[10,20,30],
                scroll : false,
        
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
                    var rowId = $('#careerList').jqGrid('getGridParam', 'selrow');
                    var id = $('#careerList').jqGrid('getRowData',rowId).id;
                    var project_name = $('#careerList').jqGrid('getRowData',rowId).project_name;
                    var date = $('#careerList').jqGrid('getRowData',rowId).date.split('~');
                    var client_name = $('#careerList').jqGrid('getRowData',rowId).client_name;
                    var task = $('#careerList').jqGrid('getRowData',rowId).task;
                    var occupation = $('#careerList').jqGrid('getRowData',rowId).occupation;
                    $("#update_career_id").val(id);
                    $("#update_career_Project_name").val(project_name);
                    $("#update_career_Start_date").val(date[0].trim());
                    $("#update_career_End_date").val(date[1].trim());
                    $("#update_career_Client_name option").filter(function(){return this.text == client_name;}).attr('selected',true);
                    $("#update_career_Task option").filter(function(){return this.text == task;}).attr('selected',true);
                    $("#update_career_Occupation option").filter(function(){return this.text == occupation;}).attr('selected',true);
                    $("#updateDetials").appendTo("body").modal('show');
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

    $("#careerList") .jqGrid({
        pager : '#careerListPager',
        recordtext: "View {0} - {1} of {2}",
        emptyrecords: "No records to view",
        loadtext: "Loading...",
        pgtext : "Page {0} of {1}"
    });

                  

    
    //근무경력
    //jqGrid 부분
    $("#workList").jqGrid({
        url:'detail/WorkList',
        datatype: 'json',
        mtype:'POST',
        editurl:'/detail/WorkEdit',
        colNames:['','work_id','info_ID','회사명','부서','담당업무','직종','직무','직위','근무기간'],
        colModel:[
                { name: 'myac', width: 30, fixed:true, sortable : false, formatter:'actions',align:"center", 
                    formatoptions:{ editbutton : false, delbutton:true}},

                {name:'id',  index:'id', sortable : false, width:20, align:"center",  hidden: true,
                    editrules:{  readonly:true,edithidden:true },editable:true,
                    editoptions:{ readonly:true,size:"50",maxlength:"50"}},

                {name:'info_id', index:'info_id', sortable : false, width:20,align:"center",hidden: true,
                    editrules:{  readonly:true,edithidden:true },editable:true,
                    editoptions:{ readonly:true,size:"50",maxlength:"50",defaultValue:link_id}},

                {name:'company_name', index:'company_name', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'department', index:'department', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'task_occupation', index:'task_occupation', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"100",maxlength:"100"}},
                
                {name:'occupation', index:'occupation', sortable : false, width:100,align:"center",hidden: true,
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'task', index:'task', sortable : false, width:100,align:"center",hidden: true,
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'spot', index:'spot', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'date', index:'date', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: $('#workListPager'),
                pagination:true,
                shrinkToFit : false,
                scroll : true,
                sortname: 'id',
                viewrecords: true,
                sortorder: "desc",
                caption: "근무경력",
                width : '900',
                rowNum:10,
                rowList:[10,20,30],
                height :'221',
        
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "id"
                },ondblClickRow: function(){
                    var rowId = $('#workList').jqGrid('getGridParam', 'selrow');
                    var id = $('#workList').jqGrid('getRowData',rowId).id;
                    var company_name = $('#workList').jqGrid('getRowData',rowId).company_name;
                    var Department = $('#workList').jqGrid('getRowData',rowId).department;
                    var date = $('#workList').jqGrid('getRowData',rowId).date.split('~');
                    var Spot = $('#workList').jqGrid('getRowData',rowId).spot;
                    var Task = $('#workList').jqGrid('getRowData',rowId).task;
                    var Occupation = $('#workList').jqGrid('getRowData',rowId).occupation;
                    $("#update_work_id").val(id);
                    $("#update_work_Company_Name").val(company_name);
                    $("#update_work_Start_date").val(date[0].trim());
                    $("#update_work_End_date").val(date[1].trim());
                    $("#update_work_Department").val(Department);
                    $("#update_work_Occupation option").filter(function(){return this.text == Occupation;}).attr('selected',true);
                    $("#update_work_Spot option").filter(function(){return this.text == Spot;}).attr('selected',true);
                    $("#update_work_Task option").filter(function(){return this.text == Task;}).attr('selected',true);
                    $("#updateDetials").appendTo("body").modal('show');
                },
                onSelectRow: function() {
                    rowId = $('#workList').jqGrid('getGridParam', 'selrow');
                    seldata = $('#workList').jqGrid('getRowData', rowId);
                    data = $('#workList').jqGrid('getRowData',rowId).id;
                    $('#param2').val(data);
                },
                loadComplete : function(xhr) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                alert(error);
                }
    });

    $("#workList") .jqGrid({
        pager : '#workListPager',
        recordtext: "View {0} - {1} of {2}",
        emptyrecords: "No records to view",
        loadtext: "Loading...",
        pgtext : "Page {0} of {1}"
    });

                  
            
    //학력
    //jqGrid 부분
    $("#educationList").jqGrid({
        url:'detail/EducationList',
        datatype: 'json',
        mtype:'POST',
        editurl:'/detail/EducationEdit',
        colNames:['', '','ID','학교명','학과(전공)','학위','수학기간'],
        colModel:[
                { name: 'myac', width: 30, fixed:true, sortable : false, formatter:'actions', align:"center",
                    formatoptions:{ editbutton : false, delbutton:true}},

                {name:'id',  index:'id', sortable : false, width:20, align:"center", hidden: true,
                    editrules:{  required:true,edithidden:true },editable:false,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'info_id', index:'info_id', sortable : false,  width:20, align:"center",hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50",defaultValue: link_id}},

                {name:'name', index:'name', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'department', index:'department', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'degree', index:'degree', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'date', index:'date', sortable : false, width:100,  align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: $('#educationListPager'),
                pagination:true,
                shrinkToFit : false,
                scroll : true,
                sortname: 'id',
                viewrecords: true,
                sortorder: "desc",
                caption: "학력",
                width : 900,
                height :'221',
                rowNum:10,
                rowList:[10,20,30],
        
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
                    var rowId = $('#educationList').jqGrid('getGridParam', 'selrow');
                    var id = $('#educationList').jqGrid('getRowData',rowId).id;
                    var Name = $('#educationList').jqGrid('getRowData',rowId).name;
                    var Department = $('#educationList').jqGrid('getRowData',rowId).department;
                    var date = $('#educationList').jqGrid('getRowData',rowId).date.split('~');
                    var degree = $('#educationList').jqGrid('getRowData',rowId).degree;
                    $("#update_edu_id").val(id);
                    $("#update_education_name").val(Name);
                    $("#update_education_start_date").val(date[0].trim());
                    $("#update_education_end_date").val(date[1].trim());
                    $("#update_education_department").val(Department);
                    $("#update_education_degree").val(degree);
                    $("#updateDetials").appendTo("body").modal('show');
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

    $("#educationList") .jqGrid({
        pager : '#educationListPager',
        recordtext: "View {0} - {1} of {2}",
        emptyrecords: "No records to view",
        loadtext: "Loading...",
        pgtext : "Page {0} of {1}"
    });             

    
    //교육사항
    //jqGrid 부분
    $("#edumatterList").jqGrid({
        url:'detail/EduMatterList',
        datatype: 'json',
        mtype:'POST',
        editurl:'/detail/EduMatterEdit',
        colNames:['', '','ID','과정명','교육기관','수료번호','기간'],
        colModel:[
                { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                    formatoptions:{ editbutton : false, delbutton:true}},

                {name:'id',  index:'id', sortable : false, width:50, align:"center",hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},   

                {name:'info_id', index:'info_id', sortable : false, width:50, align:"center",hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50", defaultValue:link_id}},

                {name:'course_name', index:'course_name', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'institation', index:'institation', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'completion_number', index:'completion_number', sortable : false,  width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'date', index:'date', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}}
                ],

                pager: $('#edumatterListPager'),
                pagination:true,
                shrinkToFit : false,
                scroll : true,
                sortname: 'id',
                viewrecords: true,
                sortorder: "desc",
                caption: "교육사항",
                width : 900,
                height :'221',
                rowNum:10,
                rowList:[10,20,30],
        
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
                    var rowId = $('#edumatterList').jqGrid('getGridParam', 'selrow');
                    var id = $('#edumatterList').jqGrid('getRowData',rowId).id;
                    var Course_Name = $('#edumatterList').jqGrid('getRowData',rowId).course_name;
                    var completion_number = $('#edumatterList').jqGrid('getRowData',rowId).completion_number;
                    var institation = $('#edumatterList').jqGrid('getRowData',rowId).institation;
                    var date = $('#edumatterList').jqGrid('getRowData',rowId).date.split('~');
                    var degree = $('#edumatterList').jqGrid('getRowData',rowId).degree;
                    $("#update_matter_id").val(id);
                    $("#update_edumatter_course_name").val(Course_Name);
                    $("#update_edumatter_completion_number").val(completion_number);
                    $("#update_edumatter_start_date").val(date[0].trim());
                    $("#update_edumatter_end_date").val(date[1].trim());
                    $("#update_edumatter_institaion_nm option").filter(function(){return this.text == institation;}).attr('selected',true);
                    $("#updateDetials").appendTo("body").modal('show');
                },
                onSelectRow: function() {

                },
                loadComplete : function(data) {

                },
                gridComplete: function() {

                },
                loadError: function(xhr,status,error) {
                console.log(error);
                }
    });

    $("#edumatterList") .jqGrid({
        pager : '#edumatterListPager',
        recordtext: "View {0} - {1} of {2}",
        emptyrecords: "No records to view",
        loadtext: "Loading...",
        pgtext : "Page {0} of {1}"
    });              


        //자격증
        //jqGrid 부분
        $("#qualificationsList").jqGrid({
            url:'detail/QualificationsList',
            datatype: 'json',
            mtype:'POST',
            editurl: '/detail/QualificationsEdit',
            colNames:['', '','ID','자격증명','발급번호','취득일','발급기관'],
            colModel:[
                    { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                        formatoptions:{ editbutton : false, delbutton:true}},

                    {name:'id',  index:'id', sortable : false,  width:50,   align:"center", hidden: true,
                    editrules:{  readonly:true,edithidden:true },editable:true,
                    editoptions:{ readonly:true,size:"50",maxlength:"50"}},

                    {name:'info_id', index:'info_id', sortable : false,  width:50,align:"center",hidden: true,
                    editrules:{  readonly:true,edithidden:true },editable:true,
                    editoptions:{ readonly:true,size:"50",maxlength:"50", defaultValue: link_id}},

                    {name:'name', index:'name', sortable : false, width:100,align:"center",
                        editrules:{  required:true,edithidden:true },editable:true,
                        editoptions:{size:"50",maxlength:"50"}},

                    {name:'reg_num', index:'reg_num', sortable : false, width:100,align:"center",
                        editrules:{  required:true,edithidden:true },editable:true,
                        editoptions:{size:"50",maxlength:"50"}},

                    {name:'reg_date', index:'reg_date', sortable : false, width:100,align:"center",
                        editrules:{  required:true,edithidden:true },editable:true,
                        editoptions:{size:"50",maxlength:"50"}},

                    {name:'issuer', index:'issuer', sortable : false, width:100,align:"center",
                        editrules:{  required:true,edithidden:true },editable:true,
                        editoptions:{size:"50",maxlength:"50"}}
                    ],

                    pager: $('#qualificationsListPager'),
                    pagination:true,
                    shrinkToFit : false,
                    scroll : true,
                    sortname: 'rnum',
                    viewrecords: true,
                    caption: "자격증",
                    width : '900',
                    height :'221',
                    rowNum:10,
                    rowList:[10,20,30],
            
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
                        var rowId = $('#qualificationsList').jqGrid('getGridParam', 'selrow');
                        var id = $('#qualificationsList').jqGrid('getRowData',rowId).id;
                        var qualname = $('#qualificationsList').jqGrid('getRowData',rowId).name;
                        var reg_num = $('#qualificationsList').jqGrid('getRowData',rowId).reg_num;
                        var reg_date = $('#qualificationsList').jqGrid('getRowData',rowId).reg_date;
                        $("#update_qualifi_ID").val(id);
                        $("#update_qualifi_nm option").filter(function(){return this.text == qualname;}).attr('selected',true);
                        $("#update_qualifi_reg_num").val(reg_num);
                        $("#update_qualfi_reg_date").val(reg_date);
                        $("#updateDetials").appendTo("body").modal('show');
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

        $("#qualificationsList") .jqGrid({
                        
            pager : '#qualificationsListPager',
            recordtext: "View {0} - {1} of {2}",
            emptyrecords: "No records to view",
            loadtext: "Loading...",
            pgtext : "Page {0} of {1}"
            
        });  


    //상훈
    //jqGrid 부분
    $("#prizeList").jqGrid({
        url:'detail/PrizeList',
        datatype: 'json',
        mtype:'POST',
        editurl:'/detail/PrizeEdit',
        colNames:['', 'prize_id','info_id','상훈명','상훈기관','연 월 일', '근거'],
        colModel:[
                { name: 'myac', width: 50, fixed:true, sortable : false, formatter:'actions', align:"center",
                    formatoptions:{ editbutton : false, delbutton:true}},

                {name:'id',  index:'id', sortable : false, width:50,   align:"center",hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50"}},

                {name:'info_id', index:'info_id', sortable : false, width:50,align:"center",hidden: true,
                editrules:{  readonly:true,edithidden:true },editable:true,
                editoptions:{ readonly:true,size:"50",maxlength:"50",defaultValue: link_id}},

                {name:'name', index:'name', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
                
                {name:'agency', index:'agency', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'reg_date', index:'reg_date', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},

                {name:'evidence', index:'evidence', sortable : false, width:100,align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
                ],

                pager: $('#prizeListPager'),
                pagination:true,
                shrinkToFit : false,
                scroll : true,
                viewrecords: true,  
                caption: "상훈",
                width : '900',
                height :'221',
                rowNum:10,
                rowList:[10,20,30],
        
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
                    var rowId = $('#prizeList').jqGrid('getGridParam', 'selrow');
                    var id = $('#prizeList').jqGrid('getRowData',rowId).id;
                    var name = $('#prizeList').jqGrid('getRowData',rowId).name;
                    var agency = $('#prizeList').jqGrid('getRowData',rowId).agency;
                    var evidence = $('#prizeList').jqGrid('getRowData',rowId).evidence;
                    var reg_date = $('#prizeList').jqGrid('getRowData',rowId).reg_date;
                    console.log(id);
                    $("#update_prize_id").val(id);
                    $("#update_prize_name").val(name);
                    $("#update_prize_agency").val(agency);
                    $("#update_prize_evidence").val(evidence);
                    $("#update_prize_reg_date").val(reg_date);
                    $("#updateDetials").appendTo("body").modal('show');
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

    $("#prizeList") .jqGrid({
        pager : '#prizeListPager',
        recordtext: "View {0} - {1} of {2}",
        emptyrecords: "No records to view",
        loadtext: "Loading...",
        pgtext : "Page {0} of {1}"
    });              
});//document.ready 끝


/* 
 * 
 * 주소 API 스크립트 
 * 
 */
function AddressSearch() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            /*// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }*/

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            /*document.getElementById('sample6_postcode').value = data.zonecode;*/
            document.getElementById("user_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("user_detail_address").focus();
        }
    }).open();
}






/* 
 * 
 * 유저 수정 스크립트 
 * 
 */
function userUpdate(){
    var myForm = document.getElementById('UpdateForm');
    var id = $("#info_id").val();
    var formData = new FormData(myForm);
    for (var pair of formData.entries()) { 
      console.log(pair[0]+ ', ' + pair[1]); 
    }
    $.ajax({  
        type: "POST",
        url: "/userUpdate",
        type : 'POST',
        datatype : "text",
        contentType : false,
        processData: false,
        data: formData,
        success:function(data){
          var info_name = $("#name").val();
          $("#detailModalLabel").text(info_name);
          $("#attachImg").val("");
          $("#attachFile").val("");
          alert("수정되었습니다.");
          $.ajax({  
            type: "get",             
            url: "/"+id+"/detail",
            contentType : false,
            processData: false,
            success:function(data){
            	location.reload();
            },
            error:function(data){
              alert("error");
            }
          });
        },
        error:function(data){
          alert("error");
        }
    });
}

/* 
 * 
 * 근무경력 추가 스크립트
 * 
 */
function workAdd(){
    var workparam = $("form[name=workForm]").serialize();
    var workparams = $("form[name=workForm]").serializeArray();
    var work_Company_Name = $("#work_Company_Name").val();
    var work_Department = $("#work_Department").val();
    var work_Start_date = $("#work_Start_date").val();
    var work_End_date = $("#work_End_date").val();
    var work_Spot = $("#work_Spot").val();
    var work_occupation = $("#work_occupation").val();
    var work_Task = $("#work_Task").val();
    if(work_Company_Name==""){
        alert("회사명을 입력해주세요");
        $("#work_Company_Name").focus();
        return;
    }
    if(work_Department==""){
        alert("부서명을 입력해주세요");
        $("#work_Department").focus();
        return;
    }
    if(work_Start_date==""){
        alert("입사일을 입력해주세요");
        $("#work_Start_date").focus();
        return;
    }
    if(work_End_date==""){
        alert("퇴사일을 입력해주세요");
        $("#work_End_date").focus();
        return;
    }
    if(work_Spot==""){
        alert("직위를 선택해주세요");
        $("#work_Spot").focus();
        return;
    }
    if(work_occupation==""){
        alert("직종을 선택해주세요");
        $("#work_occupation").focus();
        return;
    }
    if(work_Task==""){
        alert("직무를 선택해주세요");
        $("#work_Task").focus();
        return;
    }
    console.log(workparams);

    $.ajax({  
      type: "POST" ,
      url: "/detail/WorkAdd",
      data: workparam,
      success:function(data){
        Reset("work");
        $("#addDetials").modal("hide");
        $("#workList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}
/* 
 * 
 * 기술경력 추가 스크립트
 * 
 */ 
function careerAdd(){

    var careerparam = $("form[name=careerForm]").serialize();
    var career_Project_name = $("#career_Project_name").val();
    var career_Start_date = $("#career_Start_date").val();
    var career_End_date = $("#career_End_date").val();
    var career_Client_name = $("#career_Client_name").val();
    var career_occupation = $("#career_occupation").val();
    var career_Task = $("#career_Task").val();
    if(career_Project_name==""){
        alert("사업명을 입력해주세요");
        $("#career_Project_name").focus();
        return;
    }
    if(career_Start_date==""){
        alert("시작일을 입력해주세요");
        $("#career_Start_date").focus();
        return;
    }
    if(career_End_date==""){
        alert("종료일을 입력해주세요");
        $("#career_End_date").focus();
        return;
    }
    if(career_Client_name==""){
        alert("고객사를 선택해주세요");
        $("#career_Client_name").focus();
        return;
    }
    if(career_occupation==""){
        alert("직종을 선택해주세요");
        $("#career_occupation").focus();
        return;
    }
    if(career_Task==""){
        alert("직무를 선택해주세요");
        $("#career_Task").focus();
        return;
    }

    $.ajax({  
      type: "POST", 
      url: "/detail/CareerAdd",
      data: careerparam,
      success:function(data){
        Reset("career");
        $("#addDetials").modal("hide");
        $("#careerList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

/* 
 * 
 * 학력 추가 스크립트
 * 
 */
function educationAdd(){

    var educationparam = $("form[name=educationForm]").serialize();
    var education_name = $("#education_name").val();
    var education_department = $("#education_department").val();
    var education_degree = $("#education_degree").val();
    var education_start_date = $("#education_start_date").val();
    var education_end_date = $("#education_end_date").val();
    if(education_name==""){
        alert("학교명을 입력해주세요");
        $("#education_name").focus();
        return;
    }
    if(education_department==""){
        alert("학과(전공)을 입력해주세요");
        $("#education_department").focus();
        return;
    }
    if(education_degree==""){
        alert("학위를 입력해주세요");
        $("#education_degree").focus();
        return;
    }
    if(education_start_date==""){
        alert("입학날짜를 입력해주세요");
        $("#education_start_date").focus();
        return;
    }
    if(education_end_date==""){
        alert("졸업날짜를 입력해주세요");
        $("#education_end_date").focus();
        return;
    }
    
    
    $.ajax({  
      type: "POST" ,
      url: "/detail/EducationAdd",
      data: educationparam,
      success:function(data){
        Reset("education");
        $("#addDetials").modal("hide");
        $("#educationList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

/* 
 * 
 * 교육사항 추가 스크립트
 * 
 */
function edumatterAdd(){
    var edumatterparam = $("form[name=edumatterForm]").serialize();
    var edumatter_course_name = $("#edumatter_course_name").val();
    var edumatter_institaion = $("#edumatter_institaion").val();
    var edumatter_completion_number = $("#edumatter_completion_number").val();
    var edumatter_start_date = $("#edumatter_start_date").val();
    var edumatter_end_date = $("#edumatter_end_date").val();
    if(edumatter_course_name==""){
        alert("과정명을 입력해주세요");
        $("#edumatter_course_name").focus();
        return;
    }
    if(edumatter_institaion==""){
        alert("학원을 선택해주세요");
        $("#edumatter_institaion").focus();
        return;
    }
    if(edumatter_completion_number==""){
        alert("수료번호를 입력해주세요");
        $("#edumatter_completion_number").focus();
        return;
    }
    if(edumatter_start_date==""){
        alert("시작일을 입력해주세요");
        $("#edumatter_start_date").focus();
        return;
    }
    if(edumatter_end_date==""){
        alert("수료일을 입력해주세요");
        $("#edumatter_end_date").focus();
        return;
    }
    $.ajax({  
      type: "POST" ,
      url: "/detail/EduMatterAdd",
      data: edumatterparam,
      success:function(data){
        Reset("edumatter");
        $("#addDetials").modal("hide");
        $("#edumatterList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

/* 
 * 
 * 자격증 추가 스크립트
 * 
 */
function qualificationsAdd(){
    var qulifiparam = $("form[name=qualificationsForm]").serialize();
    var qualifi_nm = $("#qualifi_nm").val();
    var qualifi_reg_num = $("#qualifi_reg_num").val();
    var qualfi_reg_date = $("#qualfi_reg_date").val();
    if(qualifi_nm==""){
        alert("자격증을 선택해주세요");
        $("#qualifi_nm").focus();
        return;
    }
    if(qualifi_reg_num==""){
        alert("발급번호를 입력해주세요");
        $("#qualifi_reg_num").focus();
        return;
    }
    if(qualfi_reg_date==""){
        alert("취득일을 입력해주세요");
        $("#qualfi_reg_date").focus();
        return;
    }
    $.ajax({  
      type: "POST", 
      url: "/detail/QualificationsAdd",
      data: qulifiparam,
      success:function(data){
        Reset("qualifications");
        $("#addDetials").modal("hide");
        $("#qualificationsList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}

/* 
 * 
 * 상훈 추가 스크립트
 * 
 */
function prizeAdd(){
    var prizeparam = $("form[name=prizeForm]").serialize();
    var prize_name = $("#prize_name").val();
    var prize_agency = $("#prize_agency").val();
    var prize_evidence = $("#prize_evidence").val();
    var prize_reg_date = $("#prize_reg_date").val();
    if(prize_name==""){
        alert("상훈명을 입력해주세요");
        $("#prize_name").focus();
        return;
    }
    if(prize_agency==""){
        alert("상훈기관을 입력해주세요");
        $("#prize_agency").focus();
        return;
    }
    if(prize_evidence==""){
        alert("근거를 입력해주세요");
        $("#prize_evidence").focus();
        return;
    }
    if(prize_reg_date==""){
        alert("연 월 일을 입력해주세요");
        $("#prize_reg_date").focus();
        return;
    }
    $.ajax({  
      type: "POST" ,
      url: "/detail/PrizeAdd",
      data: prizeparam,
      success:function(data){
        Reset("prize");
        $("#addDetials").modal("hide");
        $("#prizeList").trigger("reloadGrid");
      },
      error:function(data){
        alert("error");
      }
  });
}



/* 
 * 
 * 근무경력 수정 스크립트 시작 부분 
 * 
 */
function workUpdate(){
    var workUpdateForm = $("form[name=workupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/WorkUpdate",
        data: workUpdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#workList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 기술경력 수정 스크립트 시작 부분 
 * 
 */
function careerUpdate(){
    var careerUpdateForm = $("form[name=careerupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/CareerUpdate",
        data: careerUpdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#careerList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 학력 수정 스크립트 시작 부분 
 * 
 */
function educationUpdate(){
    var educationUpdateForm = $("form[name=educationupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/EducationUpdate",
        data: educationUpdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#educationList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 교육사항 수정 스크립트 시작 부분 
 * 
 */
function edumatterUpdate(){
    var edumatterUpdateForm = $("form[name=edumatterupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/EduMatterUpdate",
        data: edumatterUpdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#edumatterList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 자격증 수정 스크립트 시작 부분 
 * 
 */
function qualificationsUpdate(){
    var qualificationsupdateForm = $("form[name=qualificationsupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/QualificationsUpdate",
        data: qualificationsupdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#qualificationsList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 상훈 수정 스크립트 시작 부분 
 * 
 */
function prizeUpdate(){
    var prizeupdateForm = $("form[name=prizeupdateForm]").serialize();

    $.ajax({  
        type: "POST" ,
        url: "/detail/PrizeUpdate",
        data: prizeupdateForm,
        success:function(data){
          $("#updateDetials").modal("hide");
          $("#prizeList").trigger("reloadGrid");
            alert('수정되었습니다.');
        },
        error:function(data){
        alert("error");
        }
    });
}

/* 
 * 
 * 파일 삭제 스크립트 시작 부분 
 * 
 */
function fileDelete(id){
    
    $.ajax({  
        type: "POST" ,
        data: id,
        url: "/fileDelete/"+id,
        success:function(data){
            alert('삭제되었습니다.');
            $("#file_list"+id).remove();
        },
        error:function(request,status,error){
        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

        alert("error");
        }
    });
}


