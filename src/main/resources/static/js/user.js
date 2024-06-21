const userFunction = {
    duplication_check: function ()  {
        let user_id = document.getElementById("user_id");
        if (user_id.value === "") {alert("User Id를 입력해주세요."); user_id.focus(); return false;}
        fetch('/user/duplication_check?user_id=' + encodeURIComponent(user_id.value), {method : 'GET'})
            .then(response => response.json())
            .then(data =>   {
                console.log(data);
                console.log(data.count);
                document.getElementById("duplication_check").value = (data.count === 0) ? "Y" : "N";
                document.getElementById("duplication_check_message").innerText = (data.count === 0)? "사용할 수 있는 ID입니다." : "ID가 중복됩니다.";
            })
            .catch(error => console.error('Error:', error));
    },
    register_user: function () {
        let duplication_check = document.getElementById("duplication_check").value;
        if (duplication_check === "N") {
            alert("ID 중복체크를 해주세요.");
            return;
        } else {
            let register_form = document.getElementById("register_form");
            register_form.submit();
        }
    }
}