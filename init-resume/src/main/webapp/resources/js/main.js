$(document).ready(function() {
	//csrf
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$("input:checkbox[name='careerChecked']").prop("checked", false);
	if(token && header){
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
	};
	
	//Enter Submit 막기
	document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
	}, true);
	
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
	            document.getElementById("info_address").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("info_detailaddress").focus();
	        }
	    }).open();
	}
	

    var rowId;
    var data;
    var seldata;
    
    ///////나이계산//////
    /*const today = new Date();
    const birthDate = new Date(2000, 7, 10); // 2000년 8월 10일

    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }

    document.writeln(age);*/

    //jqGrid 부분
    $("#userList").jqGrid({
        url:'userList',
        datatype: 'json',
        editurl:"userEdit",
        mtype:'POST',
        colNames:['','ID','사진','이름','휴대폰','이메일','만나이', '근무경력일', '기술경력일', '직종/직무','근무가능지역','자격증', '이력서'],
        colModel:[
                { name: 'myac', width: 30, fixed:true, sortable : false, formatter:'actions', align:"center",
                formatoptions:{ editbutton : false, delbutton:true, size:80}},

                {name:'id', index:'id', sortable : false, width:20, hidden: true,
                    editrules:{  readonly:true,edithidden:true },editable:true, align:"center",
                    editoptions:{ readonly:true, size:"50", maxlength:"50", hidden:true}},

                {
                    name: 'imgname', index:'imgname', align:"center",
                    width:50,
                    fixed: true,
                    formatter: function (cellvalue, options, rowObject) {
                        if(cellvalue != null){
                        return "<img src='/resources/images/"+cellvalue+"' class='img-fluid info-img' />"; 
                        }else{
                            return "<div style='text-align : center'>X</div>";
                        }
                    }
                },

                {name:'name', index:'name', sortable : true,  width:50, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
        
                {name:'phone', index:'phone', sortable : false, width:100, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
        
                {name:'email',    index:'email',   sortable : false,  width:150, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
        
                {name:'birth',  index:'birth', sortable : false,  width:50, align:"center",
                    
                    	formatter: function (cellvalue, options, rowObject) {
                            
                            	 var now=new Date();
                        		 var year = now.getFullYear();
                        			var month = now.getMonth() + 1;   
                        			var date = now.getDate();      
                        			var user_year = cellvalue.substr(0, 4);
                        			var user_month = cellvalue.substr(5, 2);
                        			var user_date = cellvalue.substr(8, 2);
                        			if((month+"").length < 2) {  // 월이 한자리 수인 경우 앞에 0을 붙여줘서 두자리로 만들어 준다.
                        			     month = "0" + month;
                        			    }
                        			 
                        			    if((date+"").length < 2) {       // 일이 한자리 수인 경우 앞에 0을 붙여준다.
                        			     date = "0" + date;
                        			    }
                        			today = year +"-" + month + "-" + date;

                                let age = year - user_year;
                                const m = month - user_month;
                                if (m < 0 || (m === 0 && date < user_date)) {
                                    age--;
                                }
                            
                            return age+"세";
                        },
                
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}
                },
                
                {name:'work_year',    index:'work_year',   sortable : false,  width:80, align:"center",
	                editrules:{  required:true,edithidden:true },editable:true,
	                editoptions:{size:"50",maxlength:"50"}},
                
                {name:'career_year',    index:'career_year',   sortable : false,  width:80, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}},
                   

                {name:'occupation',  index:'occupation',sortable : false, width:200, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}
                },

                {name:'area',  index:'area',sortable : false, width:90, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}
                },

                {name:'qualifi',  index:'qualifi',sortable : false, width:200, align:"center",
                    editrules:{  required:true,edithidden:true },editable:true,
                    editoptions:{size:"50",maxlength:"50"}
                },

                {name : 'btn', index : 'btn', width : 40, fixed : true, align : 'center', formatter:Btn}

                ],

                pager: $('#userListpager'),
                pagination:true,
                rowNum:10,
                rowList:[10,20,30],
                sortable : true,
                /*sortname : 'name',*/
                /*loadonce : true,*/
                /*sortorder : "desc",*/
                viewrecords: true,
                caption: "유저리스트",
//                autowidth : true,
                height : 'auto',

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
                    data = $('#userList').jqGrid('getRowData',rowId).id;
                    console.log(data);
                    var href = data+"/detail";
                    var info_name =$('#userList').jqGrid('getRowData',rowId).name;
                    $('#info_id').val(data);
                    $("#detailModalLabel").text(info_name);                    
                    /*$('#detailModal .modal-content').load(data+"/detail");
                    $('#detailModal').modal('show');*/
                    $(location).attr('href',href);
                },
                onSelectRow: function() {
                    rowId = $('#userList').jqGrid('getGridParam', 'selrow');
                    seldata = $('#userList').jqGrid('getRowData', rowId);
                    data = $('#userList').jqGrid('getRowData',rowId).id;
                    $('#param').val(data);
                },
                onCellSelect: function(rowid, iCol, cellcontent, e){

                },
                
                loadComplete : function(xhr) {
                	
                },
                gridComplete: function() {
                	$("#nodata").remove();
                },
                loadError: function(xhr,status,error) {
                	
                			alert(error);
                	
                }
                });
                

                function Btn(cellvalue, options, rowObject){
                	data = $('#userList').jqGrid('getRowData',rowId).id;

                    var str = "<button type='button'  id='pdf-btn"+options.rowId+"' onclick='pdfSave("+options.rowId+")' style='background-color:white; color:white; border:1; outline:0;'><img src='/resources/images/detail.png' width='20' height='auto' ></button>";
                    
                    return str;
                }

                $("#userList") .jqGrid({
                    pager : '#userListpager',
                    recordtext: "View {0} - {1} of {2}",
                    emptyrecords: "No records to view",
                    loadtext: "Loading...",
                    pgtext : "Page {0} of {1}"
                });
            

    //jqGrid 가로 길이 반응형
    $(window).on('resize.jqGrid', function() {
        $('#userList').jqGrid('setGridWidth', $(document.body).Width());
    });

    // 추가 모달창 열기
    $("#add-btn").click(function(){
        $("#addModal").appendTo("body").modal('show');
    });
    
}); //document.ready 부분



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
            document.getElementById("info_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("info_detailaddress").focus();
        }
    }).open();
}
	//검색창 경력 체크 되었을 때 값 입력할 수 있도록
	function SearchCareerChecked(){
		if(careerChecked.checked == true){
			$("#career0").attr("disabled", false);
			$("#career1").attr("disabled", false);
		}else{
			$("#career0").attr("disabled", true);
			$("#career1").attr("disabled", true);
			document.search_form.career0.value = "";
			document.search_form.career1.value = "";
		}
	}

  //검색창 직종 선택후 직무를 선택하도록
  function SearchoccupationSelected(id){
    if(id.value == 0){
      $("#search_Task option").hide();
      $(".Searchoccupation0").prop("selected", true);
      $("#search_Task").attr("disabled", true);
    }else{
      $(".searchtask").hide();
      $(".Searchoccupation"+id.value).show();
      $(".Searchoccupation0").prop("selected", true);
      $("#search_Task").attr("disabled", false);
    }
  }

  //상세페이지 직종 선택후 직무를 선택하도록
  function DetailoccupationSelected(id){
    if(id.value == 0){
      $("#user_task option").hide();
      $(".detailoccupation0").prop("selected", true);
      $("#user_task").attr("disabled", true);
    }else{
      $(".usertask").hide();
      $(".detailoccupation"+id.value).show();
      $(".detailoccupation0").prop("selected", true);
      $("#user_task").attr("disabled", false);
    }
  }

  //근무경력 추가페이지 직종 선택후 직무를 선택하도록
  function WorkoccupationSelected(id){
    if(id.value == 0){
      $("#work_Task option").hide();
      $(".workoccupation0").prop("selected", true);
      $("#work_Task").attr("disabled", true);
    }else{
      $(".workaddtask").hide();
      $(".workoccupation"+id.value).show();
      $(".workoccupation0").prop("selected", true);
      $("#work_Task").attr("disabled", false);
    }
  }

  // 기술경력 추가페이지 직종 선택후 직무를 선택하도록
  function CareeroccupationSelected(id){
    if(id.value == 0){
      $("#career_Task option").hide();
      $(".careeroccupation0").prop("selected", true);
      $("#career_Task").attr("disabled", true);
    }else{
      $(".careeraddtask").hide();
      $(".careeroccupation"+id.value).show();
      $(".careeroccupation0").prop("selected", true);
      $("#career_Task").attr("disabled", false);
    }
  }

  // 추가 후 추가창의 입력 값들 초기화
  function Reset(str){
    $("#addDetials."+str+" input").val("");
    $("#addDetials select").val("");
  }

  // 검색 결과 초기화
  function SettingReset(str){
    $("#addSetting."+str+" input").val("");
  }

  // 검색창 열고 닫기
  function searchForm(){
    if($('.searchTable').css('display') == 'none'){
          $('.searchTable').show();
          $('#search').text("검색창 ▲")
      }else{
          $('.searchTable').hide();
          $('#search').text("검색창 ▼")
      }
  }

  
  /* 
   * 
   * 검색 스크립트 끝 부분 
   * 
   */
  
  function searchUser(){
    //이름
    var name = $("input[name=nameSearch]").val();
    //지역
    var area_array = Array();
    var area_cnt = 0;
    var areachkbox = $(".areaCheckBox");

    for(i=0;i<areachkbox.length;i++) {
        if (areachkbox[i].checked == true){
            area_array[area_cnt] = areachkbox[i].value;
            area_cnt++;
        }
    }
    //경력
    var career_start = $("input[name=careerStart]").val();
    var career_end = $("input[name=careerEnd]").val();

    //자격증
    var qualifi_array = Array();
    var qualifi_cnt = 0;
    var qualifichkbox = $(".qualifiCheckBox");

    for(i=0;i<qualifichkbox.length;i++) {
        if (qualifichkbox[i].checked == true){
            qualifi_array[qualifi_cnt] = qualifichkbox[i].value;
            qualifi_cnt++;
        }
    }

    //고객사
    var client_array = Array();
    var client_cnt = 0;
    var clientchkbox = $(".clientCheckBox");

    for(i=0;i<clientchkbox.length;i++) {
        if (clientchkbox[i].checked == true){
            client_array[client_cnt] = clientchkbox[i].value;
            client_cnt++;
        }
    }
    //직종
    var occupation = $("#search_occupation option:selected").val();

    //직무
    var task = $("#search_Task option:selected").val();

    var rows = $("#userList").getGridParam("rowNum");
    var postData  = {'name' : name, 'career' : career_start, 'career_end' : career_end,'area' : area_array.toString(), 'qualifi_nm' : qualifi_array.toString(), 'client_nm' : client_array.toString(), 'task' : task, 'occupation' : occupation, 'rows' :  rows,'search_yn' : 'Y' }
    console.log(postData);  
    $("#userList").jqGrid("clearGridData", true);
          $("#userList").setGridParam({
            datatype	: "json",
            postData	: postData,
            loadComplete	: function(data) {
            	$("#nodata").remove();
            	if($('#userList').jqGrid('getRowData')[0]==null){
            		$("#userList.ui-jqgrid-btable").after("<p id='nodata' style='margin-top: 5px; text-align: center; font-weight: bold;'>검색된 자료가 없습니다</p>");
                }
            }
          }).trigger("reloadGrid");
      
  } 
  
  //검색결과 초기화 
  function searchReset(){
    var postData  = {'name' : '', 'career' : '', 'area' : '', 'qualifi' : '', 'client_nm' : '', 'task' : '', 'occupation' : '', 'rows' :  '', 'search_yn' : 'N' }
    $("#userList").setGridParam({
      datatype	: "json",
      postData	: postData,
      loadComplete	: function(data) {
      }
    }).trigger("reloadGrid");
  }
  
  /* 
   * 
   * 검색 스크립트 끝 부분 
   * 
   */
  
  
  
  /* 
   * 
   * 유저 추가 스크립트
   * 
   */
  
  function userAdd(){
      var name = $("#info_name").val();
      var birth = $("#info_birth").val();
      var tel = $("#info_phone").val();
      var email = $("#info_email").val();
      var address = $("#info_address").val();
      var detailaddress = $("#info_detailaddress").val();
      
      var area_array = Array();
      var area_cnt = 0;
      var areachkbox = $(".areaCheckBox");

      for(i=0;i<areachkbox.length;i++) {
          if (areachkbox[i].checked == true){
        	  area_array[area_cnt] = areachkbox[i].value;
        	  area_cnt++;
          }
      }
      if(name==""){
          alert("이름을 입력해주세요");
          $("#info_name").focus();
          return;
      }
      if(birth==""){
          alert("생년월일을 입력해주세요");
          $("#info_birth").focus();
          return;
      }
      if(tel==""){
          alert("전화번호를 입력해주세요");
          $("#info_phone").focus();
          return;
      }
      if(email==""){
          alert("이메일을 입력해주세요");
          $("#info_email").focus();
          return;
      }
      if(address==""){
          alert("주소를 입력해주세요");
          $("#info_address").focus();
          return;
      }
      
      
      
      var postData  = {'name' : name, 'birth' : birth, 'area' : area_array.toString(), 'phone' : tel, 'email' : email, 'address' : address, 'detailaddress' : detailaddress }
      console.log(postData);

      
      $.ajax({  
        type: "POST", 
        datatype : "json",
        url: "/userAdd",
        data: postData,
        success:function(data){
          $("#addModal").modal("hide");
          $("#userList").trigger("reloadGrid");
        },
        error:function(data){
          alert("error");
        }
    });
  } 
  

  /* 
   * 
   * PDF 저장 스크립트
   * 
   */
  
  function pdfSave(id){
	  document.search_form.id.value=id;
	  var rowId;
	  data = $('#userList').jqGrid('getRowData',id).id;
      console.log(data);
      var href = data+"/resume_pdf";
      var info_name =$('#userList').jqGrid('getRowData',id).name;
      $('#info_id').val(data);
      $("#detailModalLabel").text(info_name);                    
      /*$('#detailModal .modal-content').load(data+"/detail");
      $('#detailModal').modal('show');*/
      /*$(location).attr('href',href);*/
      /*location.href=id+"/pdfSave.do";*/
      window.open(id+"/pdfSave.do", "이력서", "width=1200, height=800, left=100, top=50"); 
      /*document.search_form.action = id + '/pdfSave.do';*/
      /*document.search_form.submit();*/
    
        /*html2canvas($('#pdfDiv')[0]).then(function(canvas) { //저장 영역 div id
		
	    // 캔버스를 이미지로 변환
	    var imgData = canvas.toDataURL('image/png');
		     
	    var imgWidth = 190; // 이미지 가로 길이(mm) / A4 기준 210mm
	    var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
	    var imgHeight = canvas.height * imgWidth / canvas.width;
	    var heightLeft = imgHeight;
	    var margin = 10; // 출력 페이지 여백설정
	    var doc = new jsPDF('p', 'mm');
	    var position = 0;
	       
	    // 첫 페이지 출력
	    doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
	    heightLeft -= pageHeight;
	         
	    // 한 페이지 이상일 경우 루프 돌면서 출력
	    while (heightLeft >= 20) {
	        position = heightLeft - imgHeight;
	        doc.addPage();
	        doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
	        heightLeft -= pageHeight;
	    }
	 
	    // 파일 저장
	    doc.save('file-name.pdf');

		  
	});*/
  }


 