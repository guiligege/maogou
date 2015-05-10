<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>

<link href="${domain_css}/css/uploadify/uploadify.css?${version_css}" rel="stylesheet">
<link href="${domain_css}/css/chongwu/fabu.css?${version_css}" rel="stylesheet">
<style>
 i {
	color: #f33;
	font-style: normal;
	font-size: 14px;
	}
</style>

  <div >
  		<ul class="process">
            <li class="onestep">
                <span class="l-bg"></span>
                <span class="r-bg"></span>
                <span class="xh">1</span>宠物                     
                            </li>
                        <li class="twostep">
                <span class="l-bg"></span>
                <span class="r-bg"></span>
                <span class="xh">2</span><span id="id_major_name">宠物狗</span>
            </li>
                               <li class="threestep active">
                <span class="l-bg"></span>
                <span class="r-bg"></span>
                <span class="xh">3</span>填写详情
            </li>
        </ul>
        <div style="margin-left: 184px;">
        	<i> * </i>
        	<span style="margin-left: 15px;font-size: 14px;">宠物链接</span>
        	<input value="请填写宠物链接（目前支持58同城，赶集网链接）" name="shareUrl" type="text" id="id_shareUrl" size="45" maxlength="30" class="input1" style="margin-left: 39px;
width: 428px;
color: grey;
font-size: 12px;"/>
        	<input id="share_submit" type="button" class="btn-style2" value="获取信息" style="margin-left: 90px;width: 85px;">
        </div>
      <div>
          <form id="login-form" action="" method="" autocomplete="off">
          <input value="${folder}" name="folder" type="hidden" id="id_folder" size="45" maxlength="30" class="input1">
	          <table width="980px;">
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td width="10%" class="tdleft">标题</td>
		           <td width="88%" class="tdright">
		           		<input value="" name="title" type="text" id="id_title" size="45" maxlength="30" class="input1">
		           		<span class="validatorMsg validatorError">请填写标题</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">地点</td>
		           <td class="tdright">
		           		<span>
		           		<select name="city" type="select" id="id_city" autocomplete="off"  class="marginright10">
		           			<option value="2,上海" selected>上海</option>
							<option value="1,北京">北京</option>
							<option value="3,杭州">杭州</option>
							<option value="4,深圳">深圳</option>
							<option value="5,苏州">苏州</option>
							<option value="6,广州">广州</option>
							<option value="7,天津">天津</option>
							<option value="8,成都">成都</option>
							<option value="9,郑州">郑州</option>
							<option value="10,武汉">武汉</option>
							<option value="11,重庆">重庆</option>
							<option value="12,温州">温州</option>
							<option value="13,南京">南京</option>
						</select>
						<select name="district" type="select" id="id_district" autocomplete="off">
							<option value="2,上海" selected>上海</option>
							<option value="33,黄浦区">黄浦区</option>
							<option value="34,卢湾区">卢湾区</option>
							<option value="35,静安区">静安区</option>
							<option value="36,徐汇区">徐汇区</option>
							<option value="37,浦东新区">浦东新区</option>
							<option value="38,长宁区">长宁区</option>
							<option value="39,虹口区">虹口区</option>
							<option value="40,杨浦区">杨浦区</option>
							<option value="41,普陀区">普陀区</option>
							<option value="42,闸北区">闸北区</option>
							<option value="43,闵行区">闵行区</option>
							<option value="44,宝山区">宝山区</option>
							<option value="45,嘉定区">嘉定区</option>
							<option value="46,青浦区">青浦区</option>
							<option value="47,奉贤区">奉贤区</option>
							<option value="48,崇明县">崇明县</option>
							<option value="49,金山区">金山区</option>
						</select>
						<span class="validatorMsg validatorError">请填写区域</span>
		           		</span>
		           </td>
	           </tr>
	           
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">价格</td>
		           <td class="tdright">
		           		<input value="" name="price" type="text" id="id_price" size="4" maxlength="6" class="input2 marginright5" >元
		           		<span class="validatorMsg validatorError">请填写价格</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">性别</td>
		           <td class="tdright space">
						<label for="id_sex_0"><input id="id_sex_0" name="sex" type="radio" value="公" checked="" autocomplete="off">公</label>
						<label for="id_sex_1"><input id="id_sex_1" name="sex" type="radio" value="母" autocomplete="off">母</label>
						<label for="id_sex_2"><input id="id_sex_2" name="sex" type="radio" value="公母均有" autocomplete="off">公母均有</label>
						<span class="validatorMsg validatorError">请填写性别</span>
		           </td>
	           </tr>
	           
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">年龄</td>
		           <td class="tdright">
		           		      <input value="" name="age" type="text" id="id_age" size="4" class="input2 marginright5" maxlength="5">
							<select name="age_type" type="select" id="id_age_type" autocomplete="off">
							<option value="1">岁</option>
							<option value="2" selected>个月</option>
							<option value="3">天</option>
							</select>
							<span class="validatorMsg validatorError">请填写年龄</span>
		           </td>
	           </tr>
	           <tr>
	           	<td width="2%"><i></i></td>
		           <td class="tdleft">卖家承诺</td>
		           <td class="tdright">
		           	<label for="checkbox_is_promise" class="checkboxright">
                    <input type="checkbox" name="checkbox_is_promise" id="checkbox_is_promise" value="15天内包退换">15天内包退换
                    </label>
                    <label for="promise_yimiao" class="checkboxright">
                    <input type="checkbox" value="疫苗齐全" name="promise_yimiao" id="promise_yimiao">疫苗齐全
                    </label>
                    <span class="validatorMsg validatorError">请填写包退换天数</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">描述</td>
		           <td class="tdright">
		           		<textarea name="description" type="textarea" id="id_description" class="textarea1" rows="6" cols="50" autocomplete="off" maxlength=1000>请输入1000字以内宠物描述信息，描述越完整，买家对宠物的了解就更多哟！</textarea>
		           		<span class="validatorMsg validatorError">请填写描述</span>
		           </td>
	           </tr>
	           <tr>
	           <td width="2%"><i></i></td>
		           <td class="tdleft">上传照片</td>
		           <td class="tdright">
				        <div id="container"></div>
		                <!--文件上传-->
		                <input type="hidden" name="taskUrl" id="taskUrl" class="inputstyle"/>
		                <div class="innerdiv" ><span class="textarealeft"></span><div id="some_file_queue" class="textareastyle"></div><span class="fn-notice"></span></div>
		                <span class="validatorMsg validatorError">请上传照片</span>
		                <div class="innerdiv" style="color:grey;margin: 5px;">导入文件格式只支持.jpg,一次最多导入4个文件，且每个文件大小不超过350kB<span style="color:red">（单击文件名，即可删除文件）</span></div>
		                <div class="innerdiv" >
		                <input type="file" name="uploadify" id="uploadify" />
		                </div>
			        </td>
	           </tr>
	           
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">类别</td>
		           <td class="tdright space" style="padding-top: 15px;padding-bottom: 10px;font-size: 12px;">
		           		<label><input type="radio" name="minor_category" checked="checked" size="12" maxlength="30" value="21,哈士奇" autocomplete="off">哈士奇</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="23,松狮犬" autocomplete="off">松狮犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="24,金毛犬" autocomplete="off">金毛犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="25,秋田犬" autocomplete="off">秋田犬</label>
		           		<label><input type="radio" name="minor_category"   size="12" maxlength="30" value="1,泰迪犬" autocomplete="off">泰迪犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="2,贵宾犬" autocomplete="off">贵宾犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="3,博美犬" autocomplete="off">博美犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="4,吉娃娃" autocomplete="off">吉娃娃</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="5,比熊犬" autocomplete="off">比熊犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="6,斗牛犬" autocomplete="off">斗牛犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="8,巴哥犬" autocomplete="off">巴哥犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="9,小鹿犬" autocomplete="off">小鹿犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="10,柯基犬" autocomplete="off">柯基犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="11,可卡犬" autocomplete="off">可卡犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="12,腊肠犬" autocomplete="off">腊肠犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="14,蝴蝶犬" autocomplete="off">蝴蝶犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="15,西高地" autocomplete="off">西高地</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="18,比格犬" autocomplete="off">比格犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="19,雪纳瑞" autocomplete="off">雪纳瑞</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="20,冠毛犬" autocomplete="off">冠毛犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="27,牛头梗" autocomplete="off">牛头梗</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="34,银狐犬" autocomplete="off">银狐犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="35,沙皮犬" autocomplete="off">沙皮犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="40,罗威纳" autocomplete="off">罗威纳</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="45,大白熊" autocomplete="off">大白熊</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="46,圣伯纳" autocomplete="off">圣伯纳</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="43,卡斯罗" autocomplete="off">卡斯罗</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="44,比特" autocomplete="off">比特犬</label>
		           		
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="36,杜高" autocomplete="off">杜高</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="37,黑背" autocomplete="off">黑背</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="39,藏獒" autocomplete="off">藏獒</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="47,马犬" autocomplete="off">马犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="13,京巴" autocomplete="off">京巴</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="26,柴犬" autocomplete="off">柴犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="17,杜宾" autocomplete="off">杜宾</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="32,古牧" autocomplete="off">古牧</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="22,萨摩耶犬" autocomplete="off">萨摩耶犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="7,约克夏犬" autocomplete="off">约克夏犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="42,高加索犬" autocomplete="off">高加索犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="33,喜乐蒂犬" autocomplete="off">喜乐蒂犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="16,马尔济斯" autocomplete="off">马尔济斯</label>
		           		
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="28,拉布拉多犬" autocomplete="off">拉布拉多犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="29,边境牧羊犬" autocomplete="off">边境牧羊犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="30,德国牧羊犬" autocomplete="off">德国牧羊犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="31,苏格兰牧羊犬" autocomplete="off">苏格兰牧羊犬</label>
		           		<label><input type="radio" name="minor_category" size="12" maxlength="30" value="38,阿拉斯加雪橇犬" autocomplete="off">阿拉斯加雪橇犬</label>
		           		
		           		
		           		<span class="validatorMsg validatorError">请填写类别</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i></i></td>
		           <td class="tdleft">QQ</td>
		           <td class="tdright">
		           		<input value="" id="qq"  name="im" type="text" size="20" class="input1" maxlength="13">
		           		<span class="validatorMsg validatorError">请填写描述</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">手机</td>
		           <td class="tdright">
		           		<input value="" name="phone" type="text" id="id_phone" size="20" class="input1" maxlength="30">
		           		<span class="validatorMsg validatorError">请填写电话</span>
		           </td>
	           </tr>
	           <tr>
	           	   <td width="2%"><i> * </i></td>
		           <td class="tdleft">联系人</td>
		           <td class="tdright">
		           		<input value="" name="person" id="id_person" type="text" size="20" class="input1" maxlength="6">
		           		<span class="validatorMsg validatorError">请填写联系人</span>
		           </td>
	           </tr>
	           <tr id="pub_sumit_show">
                    <td>&nbsp;</td>
                    <td></td>
                    <td id="submiting"><input id="pub_submit" type="button" class="btn-style2" value="立即发布>>">
                    </td>
               </tr>
	          </table>
          </form>
      </div>
  </div>
  
 <%--  <script  src="${domain_js}/js/jquery/post.js?${version_js}" type="text/javascript"></script> --%>
    <script src="${domain_js}/js/uploadify/jquery.uploadify.min.js?${version_js}" type="text/javascript"></script>
   <!-- 将声明的普通上传控件与Uploadify插件绑定 -->
    <script type="text/javascript">
        window.E = function( x ){ console.log(x );}
        //uploadify for 文件上传
        var filesobj = (window.filesobj || {});
        var folder=$("#id_folder").val();
        $(function() {
            $("#uploadify").uploadify({
                buttonText    : '上传照片',      //按钮文字
                fileObjName   : 'file',
                auto          : true,            //是否自动上传
                queueID       : 'some_file_queue',//队列信息
                uploadLimit   : 4,                //队列允许最大值
                multi         :true,              //是否允许多文件
                height        : 30,               //高
                swf           : '../../img/uploadify/uploadify.swf', //swf文件路径
                uploader      : '/chongwu/upload?folder='+folder,  //上传请求
                width         : 120,              //宽
                fileSizeLimit : '350KB',           //文件大小限制
                queueSizeLimit : 4,               //队列文件数
                progressData : 'speed',           //处理速度
                fileTypeExts : ' *.jpg',          //文件类型
                fileTypeDesc : '请上传图片类型数据',
                //事件
                //上传完成事件
                onUploadComplete : function(file) {
                    //$('#uploadify').uploadify('upload');
                    $("#taskUrl").val($("#taskUrl").val()+"," + (folder+"/"+file.name));
                    filesobj[ file.id ] = folder+"/"+file.name;
                    
                    alert('文件 ' + file.name + ' 上传已经完成.');
                },
                //上传失败异常处理
                onUploadError : function(file, errorCode, errorMsg, errorString) {
                	alert('文件 ' + file.name + ' 上传异常!');
                },
                //清除队列事件
                onClearQueue : function(queueItemCount) {
                    alert(queueItemCount + ' file(s) 已经被移除');
                },
                //取消事件
                onCancel : function(file) {
                	
                    alert('文件 ' + file.name + ' 被取消.');
                },
                onDialogClose : function(){
                    window.$upload = window.$upload || this;
                } ,
                onSelect    : function(){
                    E( arguments );
                }
            });
        });
        //删除文件
        $( "#some_file_queue" ).on( "click" , ".uploadify-queue-item" , function(){
            var _id = $( this ).attr( "id" );
            //alert(filesobj[ this.id ]);
            var fullname =$( this ).find('.fileName').text();
            var subname_size =fullname.indexOf('(');
            var subname=fullname.substring(0,subname_size);
            if(!confirm('确认删除文件'+subname+'?')){
                 return false;
            }
             // $(this).remove();
             delete filesobj[ this.id ];
             $('#uploadify').uploadify('cancel', _id);
             alert( subname+"已经被移除!" );
            //删除文件 
           /** $post( "http://ums-admin.vip.vip.com/usertask/delete" , postData , function( rtn ){
                    var _error;
                    if( rtn.code == 200 ){
                    //页面删除文件
                       // delete filesobj[ this.id ];
                        alert( subname+"已经被移除!" );
                    } 
                    else {
                        _error = {
                            1007    : "任务文件不存在！"
                        };
                        $post.alert( _error[ rtn.code ] || "抱歉，服务器繁忙，请稍候再试！" );
                    };
                } );**/
        } );
          //描述信息focus
          $("#id_description")
          .on( "focus",function(){
        	  $(this).html("");
        	  $(this).siblings(".validatorMsg").hide();
          }).on( "blur",function(){
        	  if($(this).val()==''){
        		  $(this).html("请输入1000字以内宠物描述信息，描述越完整，买家对宠物的了解就更多哟！");
        	  }
          });
        //描述信息focus
          $("#id_shareUrl")
          .on( "focus",function(){
        	  $(this).val("");
          }).on( "blur",function(){
        	  if($(this).val()==''){
        		  $(this).val("请填写宠物链接（目前支持58同城，赶集网链接）");
        	  }
          });
        
          $("#id_title")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          $("#id_city")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          $("#id_price")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          $("#id_age")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          $("#id_phone")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          $("#id_person")
          .on( "focus",function(){
        	  $(this).siblings(".validatorMsg").hide();
          });
          
          //表单提交
          $("#pub_submit").on( "click", function(){
        	  //验证表单信息
        	  if(!verifyForminfo()){
        		  //验证失败不提交
        		  return;
        	  }
        	  //上传图片
        	  //$('#uploadify').uploadify('upload','*');
        	  if(filesobj.length>4){
        		  var $this=$("#taskUrl");
           		  //提示错误信息
           		  $this.siblings(".validatorMsg").html("一次最多上传4张图片!").show();
           		  return false;
        	  }
        	  var images='';
        	  var imageurl= [];
 			  for(var  str in filesobj){
 					imageurl.push(filesobj[str]);
 			  }
 			  images=imageurl.join(',');
        	  //if(!verify_images()){
        	  //	  return;
        	  //}
        	//id_title,id_city,id_district,id_price,id_age,id_age_type
        	  //promise_yimiao,checkbox_is_promise,promise_days,promise_quchong
        	  //id_description,taskUrl,qq,id_phone,id_person
        	  var category = $("input[name='minor_category']:checked").val();
        	  var sex = $("input[name='sex']:checked").val();
        	  var title=$("#id_title").val();
        	  var city=$("#id_city").val();
        	  var district=$("#id_district").val();
        	  var price=$("#id_price").val();
        	  var age=$("#id_age").val();
        	  var age_type=$("#id_age_type").val();
        	  var yimiao=$("#promise_yimiao").val();
        	  var days=$("#promise_days").val();
        	  var description=$("#id_description").val();
        	  var taskUrl=$("#taskUrl").val();
        	  var qq=$("#qq").val();
        	  var phone=$("#id_phone").val();
        	  var person=$("#id_person").val();
        	  //年龄
        	  var dogage=age;
        	  if(age_type=='1'){
        		  dogage+='岁';
        	  }
        	  if(age_type=='2'){
        		  dogage+='个月';
        	  }
        	  if(age_type=='3'){
        		  dogage+='天';
        	  }
        	  //疫苗
        	  var yimiao_promise=$("#checkbox_is_promise").val()+"--"+$("#promise_yimiao").val();
        	  
        	  //设置传入参数
        	  var postData = {
        			  title    	 : $("#id_title").val().trim(),
        			  nickName   : $("#id_person").val().trim(),
        			  qq    	 : $("#qq").val().trim(),
        			  telephone  : $("#id_phone").val().trim(),
        			  city    	 : $("#id_city").val().trim(),
        			  address    : $("#id_district").val().trim(),
        			  age    	 : dogage,
        			  yimiao     : yimiao_promise.trim(),
        			  category   : $("input[name='minor_category']:checked").val().trim(),
        			  price    	 : $("#id_price").val().trim(),
        			  sex    	 : $("input[name='sex']:checked").val().trim(),
        			  descrip    : $("#id_description").val().trim(),
        			  imageDetail : images,
                  };
        	  //提交表单 
              $.post( "/chongwu/fabu.htm" , postData , function( rtn ){
                      var _error;
                      alert(rtn.code);
                      if( rtn.code == 200 ){
                      //页面删除文件
                      alert("执行成功!");
                      } 
                      else {
                          _error = {
                              1007    : "任务文件不存在！"
                          };
                      };
               });
          });
          //验证表单信息
          function verifyForminfo(){
        	  //定义数组
        	  var verify_array = [];// 创建数组
        	  verify_array.push(verify_title()); // 添加到最后
        	  verify_array.push(verify_city());
        	  verify_array.push(verify_category());
        	  verify_array.push(verify_price());
        	  verify_array.push(verify_sex());
        	  verify_array.push(verify_age());
        	  verify_array.push(verify_desc());
        	  verify_array.push(verify_phone());
        	  verify_array.push(verify_person());
        	  verify_array.push(verify_age_num());
        	  verify_array.push(verify_price_num());
        	  //验证所有信息正常
        	  for(var index in verify_array){
        		  if(!verify_array[index]){
        			  console.log("aaaa");
        			  return false;
        		  }
        	  }
        	  return true;
          }
          
          //验证title
          function verify_title(){
        	  var $this=$("#id_title");
        	  var title = $this.val();
        	  if(title ==''  || title.lenth>30){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请输入长度小于30个字符的标题!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证市和区
          function verify_city(){
        	  var $this=$("#id_city");
        	  var city = $this.val();
        	  var district = $("#id_district").val();
        	  if(city =='' || district=='' ){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请选择市区!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证类别
          function verify_category(){
        	  var $this=$("input[name='minor_category']:checked");
        	  var category = $this.val();
        	  if(category ==''){
        		  //提示错误信息
        		  $this.parent().siblings(".validatorMsg").html("请选择类别!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证价格
          function verify_price(){
        	  var $this=$("#id_price");
        	  var title = $this.val();
        	  if(title ==''){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写价格!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证性别
          function verify_sex(){
        	  var $this=$("input[name='sex']:checked");
        	  var title = $this.val();
        	  if(title ==''){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请选择性别 !").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证年龄
          function verify_age(){
        	  var $this=$("#id_age");
        	  var title = $this.val();
        	  if(title ==''){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写年龄!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证描述
          function verify_desc(){
        	  var $this=$("#id_description");
        	  var title = $this.val();
        	  if(title =='' || title=='请输入1000字以内宠物描述信息，描述越完整，买家对宠物的了解就更多哟！'){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写宠物描述!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证手机号
          function verify_phone(){
        	  var $this=$("#id_phone");
        	  var phone = $this.val();
        	  if(phone ==''){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写您的手机号!").show();
        		  return false;
        	  }else if(!isPhone(phone)){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写正确的手机号!").show();
        		  return false;
        	  }else{
        		  return true;
        	  }
          }
          //验证联系人
          function verify_person(){
        	  var $this=$("#id_person");
        	  var person = $this.val();
        	  if(person ==''){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写联系人!").show();
        		  return false;
        	  }else if(!isXingming(person)){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写五个字以内的联系人!").show();
        		  return false;
        	  }
        	  else{
        		  return true;
        	  }
          }
          //验证图片
          function verify_images(){
        	  var $this=$("#taskUrl");
        	  if(filesobj.length==0){
        		//提示错误信息
        		 $this.siblings(".validatorMsg").html("请上传图片!").show();
        		  return false;
        	  }
        	  if(taskurl ==''){
        		  
        	  }else{
        		  return true;
        	  }
          }
          //验证年龄数字
          function verify_age_num(){
        	  var $this=$("#id_age");
        	  var age = $this.val();
        	  var age_type =$("#id_age_type").val();
        	  if(!isNumber(age)){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写正确的年龄!").show();
        		  return false;
        	  }else{
        		  //岁
        		  if(age_type=='1' && parseInt(age)>100){
        			//提示错误信息
            		  $this.siblings(".validatorMsg").html("宠物年龄不能大于100!").show();
            		  return false;
        		  }
        		  //月
        		  if(age_type=='2' && parseInt(age)>12){
        			//提示错误信息
            		  $this.siblings(".validatorMsg").html("宠物年龄月数不能大于12!").show();
            		  return false;
        		  }
        		  //天
        		  if(age_type=='3' && parseInt(age)>365){
        			//提示错误信息
            		  $this.siblings(".validatorMsg").html("宠物年龄天数不能大于365!").show();
            		  return false;
        		  }
        		  return true;
        	  }
          }
          
        //验证价格数字
          function verify_price_num(){
        	  var $this=$("#id_price");
        	  var price = $this.val();
        	  if(!isNumber(price)){
        		  //提示错误信息
        		  $this.siblings(".validatorMsg").html("请填写正确的价格!").show();
        		  return false;
        	  }else{
        		  if(parseInt(price)>100000000){
        			//提示错误信息
            		  $this.siblings(".validatorMsg").html("请填写正确的价格!").show();
            		  return false;
        		  }
        		  return true;
        	  }
          }
          //检查数字
          function isNumber(str){
        	  var re = /^[1-9]+[0-9]*]*$/;   //判断正整数 /^[1-9]+[0-9]*]*$/  
       	     if (!re.test(str)){
       	        return false;
       	     }else{
       	    	 return true;
       	     }
          }
          //检查手机号
          function isPhone(tel){
        	  var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
        	  if (reg.test(tel)) {
        	       return true;
        	  }else{
        		  return false;
        	  };
          }
          //检查姓名
          function isXingming(name){
        	  if (name.length>5) {
        	       return false;
        	  }else{
        		  return true;
        	  };
          }
          //关联市对应的区
          $('#id_city').change(function(){
        	  var city=$('#id_city').val();
        	  var district_html='';
			  //如果是北京
        	  if(city=='1,北京'){
        		 	district_html+='<option value="1,北京">北京</option>';
        		 	district_html+='<option value="14,朝阳区">朝阳区</option>';
        		 	district_html+='<option value="15,海淀区">海淀区</option>';
        		 	district_html+='<option value="16,东城区">东城区</option>';
        		 	district_html+='<option value="17,西城区">西城区</option>';
        		 	district_html+='<option value="18,崇文">崇文</option>';
        		 	district_html+='<option value="19,宣武">宣武</option>';
        		 	district_html+='<option value="20,丰台区">丰台区</option>';
        		 	district_html+='<option value="21,通州区">通州区</option>';
        		 	district_html+='<option value="22,石景山区">石景山区</option>';
        		 	district_html+='<option value="23,房山区">房山区</option>';
        		 	district_html+='<option value="24,昌平区">昌平区</option>';
        		 	district_html+='<option value="25,大兴区">大兴区</option>';
        		 	district_html+='<option value="26,顺义区">顺义区</option>';
        		 	district_html+='<option value="27,密云县">密云县</option>';
        		 	district_html+='<option value="28,怀柔区">怀柔区</option>';
        		 	district_html+='<option value="29,延庆县">延庆县</option>';
        		 	district_html+='<option value="30,平谷区">平谷区</option>';
        		 	district_html+='<option value="31,门头沟区">门头沟区</option>';
        		 	district_html+='<option value="32,燕郊">燕郊</option>';
        		  $("#id_district").html(district_html);
        	  }
			  if(city=='2,上海'){
				  district_html+='<option value="2,上海" selected>上海</option>';
				  district_html+='<option value="33,黄浦区">黄浦区</option>';
				  district_html+='<option value="34,卢湾区">卢湾区</option>';
				  district_html+='<option value="35,静安区">静安区</option>';
				  district_html+='<option value="36,徐汇区">徐汇区</option>';
				  district_html+='<option value="37,浦东新区">浦东新区</option>';
				  district_html+='<option value="38,长宁区">长宁区</option>';
				  district_html+='<option value="39,虹口区">虹口区</option>';
				  district_html+='<option value="40,杨浦区">杨浦区</option>';
				  district_html+='<option value="41,普陀区">普陀区</option>';
				  district_html+='<option value="42,闸北区">闸北区</option>';
				  district_html+='<option value="43,闵行区">闵行区</option>';
				  district_html+='<option value="44,宝山区">宝山区</option>';
				  district_html+='<option value="45,嘉定区">嘉定区</option>';
				  district_html+='<option value="46,青浦区">青浦区</option>';
				  district_html+='<option value="47,奉贤区">奉贤区</option>';
				  district_html+='<option value="48,崇明县">崇明县</option>';
				  district_html+='<option value="49,金山区">金山区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='3,杭州'){
				  district_html+='<option value="3,杭州" selected>杭州</option>';
				  district_html+='<option value="50,西湖区">西湖区</option>';
				  district_html+='<option value="51,拱墅区">拱墅区</option>';
				  district_html+='<option value="52,江干区">江干区</option>';
				  district_html+='<option value="53,下城区">下城区</option>';
				  district_html+='<option value="54,上城区">上城区</option>';
				  district_html+='<option value="55,余杭区">余杭区</option>';
				  district_html+='<option value="56,萧山区">萧山区</option>';
				  district_html+='<option value="57,滨江区">滨江区</option>';
				  district_html+='<option value="58,建德市">建德市</option>';
				  district_html+='<option value="59,富阳区">富阳区</option>';
				  district_html+='<option value="60,临安市">临安市</option>';
				  district_html+='<option value="61,桐庐县">桐庐县</option>';
				  district_html+='<option value="62,淳安县">淳安县</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='4,深圳'){
				  district_html+='<option value="4,深圳" selected>深圳</option>';
				  district_html+='<option value="63,罗湖区">罗湖区</option>';
				  district_html+='<option value="64,福田区">福田区</option>';
				  district_html+='<option value="65,南山区">南山区</option>';
				  district_html+='<option value="66,盐田区">盐田区</option>';
				  district_html+='<option value="67,宝安区">宝安区</option>';
				  district_html+='<option value="68,龙岗区">龙岗区</option>';
				  district_html+='<option value="69,布吉">布吉</option>';
				  district_html+='<option value="70,坪山新区">坪山新区</option>';
				  district_html+='<option value="71,光明新区">光明新区</option>';
				  district_html+='<option value="72,龙华新区">龙华新区</option>';
				  district_html+='<option value="73,大鹏新区">大鹏新区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='5,苏州'){
				  district_html+='<option value="5,苏州" selected>苏州</option>';
				  district_html+='<option value="74,沧浪区">沧浪区</option>';
				  district_html+='<option value="75,相城区">相城区</option>';
				  district_html+='<option value="76,平江区">平江区</option>';
				  district_html+='<option value="77,金阊区">金阊区</option>';
				  district_html+='<option value="78,工业园区">工业园区</option>';
				  district_html+='<option value="79,吴中区">吴中区</option>';
				  district_html+='<option value="80,昆山市">昆山市</option>';
				  district_html+='<option value="81,常熟市">常熟市</option>';
				  district_html+='<option value="82,张家港市">张家港市</option>';
				  district_html+='<option value="83,太仓市">太仓市</option>';
				  district_html+='<option value="84,吴江">吴江</option>';
				  district_html+='<option value="85,高新区">高新区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='6,广州'){
				  district_html+='<option value="6,广州" selected>广州</option>';
				  district_html+='<option value="86,天河区">天河区</option>';
				  district_html+='<option value="87,海珠区">海珠区</option>';
				  district_html+='<option value="88,越秀区">越秀区</option>';
				  district_html+='<option value="89,白云区">白云区</option>';
				  district_html+='<option value="90,荔湾区">荔湾区</option>';
				  district_html+='<option value="91,番禺区">番禺区</option>';
				  district_html+='<option value="92,黄埔区">黄埔区</option>';
				  district_html+='<option value="93,花都区">花都区</option>';
				  district_html+='<option value="94,萝岗区">萝岗区</option>';
				  district_html+='<option value="95,增城区">增城区</option>';
				  district_html+='<option value="96,东莞市">东莞市</option>';
				  district_html+='<option value="97,佛山市">佛山市</option>';
				  district_html+='<option value="98,从化市">从化市</option>';
				  district_html+='<option value="99,南沙区">南沙区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='7,天津'){
				  district_html+='<option value="7,天津" selected>天津</option>';
				  district_html+='<option value="100,南开区">南开区</option>';
				  district_html+='<option value="101,河西区">河西区</option>';
				  district_html+='<option value="102,河东区">河东区</option>';
				  district_html+='<option value="103,和平区">和平区</option>';
				  district_html+='<option value="104,河北区">河北区</option>';
				  district_html+='<option value="105,红桥区">红桥区</option>';
				  district_html+='<option value="106,塘沽">塘沽</option>';
				  district_html+='<option value="107,东丽区">东丽区</option>';
				  district_html+='<option value="108,西青区">西青区</option>';
				  district_html+='<option value="109,北辰区">北辰区</option>';
				  district_html+='<option value="110,津南区">津南区</option>';
				  district_html+='<option value="111,开发区">开发区</option>';
				  district_html+='<option value="112,大港">大港</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='8,成都'){
				  district_html+='<option value="8,成都" selected>成都</option>';
				  district_html+='<option value="113,武侯区">武侯区</option>';
				  district_html+='<option value="114,锦江区">锦江区</option>';
				  district_html+='<option value="115,成华区">成华区</option>';
				  district_html+='<option value="116,金牛区">金牛区</option>';
				  district_html+='<option value="117,青羊区">青羊区</option>';
				  district_html+='<option value="118,都江堰市">都江堰市</option>';
				  district_html+='<option value="119,新都区">新都区</option>';
				  district_html+='<option value="120,郫县">郫县</option>';
				  district_html+='<option value="121,温江区">温江区</option>';
				  district_html+='<option value="122,龙泉驿区">龙泉驿区</option>';
				  district_html+='<option value="123,双流区">双流区</option>';
				  district_html+='<option value="124,高新区">高新区</option>';
				  district_html+='<option value="125,高新西区">高新西区</option>';
				  district_html+='<option value="126,新津县">新津县</option>';
				  district_html+='<option value="127,邛崃市">邛崃市</option>';
				  district_html+='<option value="128,崇州市">崇州市</option>';
				  district_html+='<option value="129,大邑县">大邑县</option>';
				  district_html+='<option value="130,蒲江县">蒲江县</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='9,郑州'){
				  district_html+='<option value="9,郑州" selected>郑州</option>';
				  district_html+='<option value="131,中原区">中原区</option>';
				  district_html+='<option value="132,二七区">二七区</option>';
				  district_html+='<option value="133,管城区">管城区</option>';
				  district_html+='<option value="134,金水区">金水区</option>';
				  district_html+='<option value="135,上街区">上街区</option>';
				  district_html+='<option value="136,惠济区">惠济区</option>';
				  district_html+='<option value="137,郑东新区">郑东新区</option>';
				  district_html+='<option value="138,高新区">高新区</option>';
				  district_html+='<option value="139,经开区">经开区</option>';
				  district_html+='<option value="140,航空港">航空港</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='10,武汉'){
				  district_html+='<option value="10,武汉" selected>武汉</option>';
				  district_html+='<option value="141,武昌区">武昌区</option>';
				  district_html+='<option value="142,洪山区">洪山区</option>';
				  district_html+='<option value="143,黄陂区">黄陂区</option>';
				  district_html+='<option value="144,江岸区">江岸区</option>';
				  district_html+='<option value="145,东西湖区">东西湖区</option>';
				  district_html+='<option value="146,江汉区">江汉区</option>';
				  district_html+='<option value="147,蔡甸区">蔡甸区</option>';
				  district_html+='<option value="148,沌口开发区">沌口开发区</option>';
				  district_html+='<option value="149,汉阳区">汉阳区</option>';
				  district_html+='<option value="150,硚口区">硚口区</option>';
				  district_html+='<option value="151,江夏区">江夏区</option>';
				  district_html+='<option value="152,青山区">青山区</option>';
				  district_html+='<option value="153,新洲区">新洲区</option>';
				  district_html+='<option value="154,汉南区">汉南区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='11,重庆'){
				  district_html+='<option value="11,重庆" selected>重庆</option>';
				  district_html+='<option value="155,渝中区">渝中区</option>';
				  district_html+='<option value="156,大渡口区">大渡口区</option>';
				  district_html+='<option value="157,江北区">江北区</option>';
				  district_html+='<option value="158,沙坪坝区">沙坪坝区</option>';
				  district_html+='<option value="159,九龙坡区">九龙坡区</option>';
				  district_html+='<option value="160,南岸区">南岸区</option>';
				  district_html+='<option value="161,北碚区">北碚区</option>';
				  district_html+='<option value="162,万盛区">万盛区</option>';
				  district_html+='<option value="163,双桥区">双桥区</option>';
				  district_html+='<option value="164,渝北区">渝北区</option>';
				  district_html+='<option value="165,两江新区">两江新区</option>';
				  district_html+='<option value="166,巴南区">巴南区</option>';
				  district_html+='<option value="167,万州区">万州区</option>';
				  district_html+='<option value="168,涪陵区">涪陵区</option>';
				  district_html+='<option value="169,黔江县">黔江县</option>';
				  district_html+='<option value="170,长寿区">长寿区</option>';
				  district_html+='<option value="171,江津区">江津区</option>';
				  district_html+='<option value="172,合川区">合川区</option>';
				  district_html+='<option value="173,永川区">永川区</option>';
				  district_html+='<option value="174,南川区">南川区</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='12,温州'){
				  district_html+='<option value="12,温州" selected>温州</option>';
				  district_html+='<option value="175,鹿城区">鹿城区</option>';
				  district_html+='<option value="176,龙湾区">龙湾区</option>';
				  district_html+='<option value="177,瓯海区">瓯海区</option>';
				  district_html+='<option value="178,乐清市">乐清市</option>';
				  district_html+='<option value="179,瑞安市">瑞安市</option>';
				  district_html+='<option value="180,永嘉县">永嘉县</option>';
				  district_html+='<option value="181,洞头县">洞头县</option>';
				  district_html+='<option value="182,平阳县">平阳县</option>';
				  district_html+='<option value="183,苍南县">苍南县</option>';
				  district_html+='<option value="184,泰顺县">泰顺县</option>';
				  district_html+='<option value="185,文成县">文成县</option>';
				  $("#id_district").html(district_html);
			  }
			  if(city=='13,南京'){
				  district_html+='<option value="13,南京" selected>南京</option>';
				  district_html+='<option value="186,玄武区">玄武区</option>';
				  district_html+='<option value="187,鼓楼区">鼓楼区</option>';
				  district_html+='<option value="188,建邺区">建邺区</option>';
				  district_html+='<option value="189,白下区">白下区</option>';
				  district_html+='<option value="190,秦淮区">秦淮区</option>';
				  district_html+='<option value="191,下关区">下关区</option>';
				  district_html+='<option value="192,雨花台区">雨花台区</option>';
				  district_html+='<option value="193,浦口区">浦口区</option>';
				  district_html+='<option value="194,栖霞区">栖霞区</option>';
				  district_html+='<option value="195,江宁区">江宁区</option>';
				  district_html+='<option value="196,六合区">六合区</option>';
				  district_html+='<option value="197,高淳县">高淳县</option>';
				  district_html+='<option value="198,溧水县">溧水县</option>';
				  district_html+='<option value="199,大厂">大厂</option>';
				  $("#id_district").html(district_html);
			  }
          });
    </script>