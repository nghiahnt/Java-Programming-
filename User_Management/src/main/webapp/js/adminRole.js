var adminEdit = document.querySelectorAll('[id="adminEdit"]');
var adminDelete = document.querySelectorAll('[id="adminDelete"]');

adminEdit.forEach(function(element) {
	element.onclick = function () {
		console.log("edit");
	}
});

adminDelete.forEach(function (element) {
	element.onclick = function () {
		console.log("delete");
	}
});

var exportExcel = document.getElementById("exportExcel");
exportExcel.onclick = function () {
	
}
