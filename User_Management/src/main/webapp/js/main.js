var modal = document.getElementById("modal-container");
var closeBtn = document.getElementById("close-btn");
var cancle = document.getElementById("cancle");

var username = document.getElementById("username");

var saveBtn = document.getElementById("saveBtn-modal");

closeBtn.onclick = function() {
	modal.style.display = "none";
}

cancle.onclick = function() {
	modal.style.display = "none";
};

username.onclick = function() {
	modal.style.display = "block";
	console.log("click!");
}

function submitForm() {
	var uname = document.getElementById("name").value;
	var upwd = document.getElementById("password").value;
	var uemail = document.getElementById("email").value;
	var umobile = document.getElementById("mobile").value;

	// console.log(uname, upwd, uemail, umobile);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "updateUser", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			alert("User updated successfully");
			modal.style.display = "none";
			// Handle success (you can refresh the page or close the modal here)
		}
	};
	xhr.send("uname=" + encodeURIComponent(uname) + "&upwd=" + encodeURIComponent(upwd) + "&uemail=" + encodeURIComponent(uemail) + "&umobile=" + encodeURIComponent(umobile));

}

saveBtn.onclick = function() {
	//	console.log("ok");
	submitForm();
}