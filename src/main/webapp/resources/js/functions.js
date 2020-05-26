function modifyDiscipline() {
    var checkboxes = $('input[type=checkbox]:checked');
    if(checkboxes.length == 0){
        alert("Пожалуйста, выберите хотя бы одну дисциплину!");
        return;
    }

    if(checkboxes.length > 1){
        alert("Пожалуйста, выберите только одну дисциплину!");
        return;
    }

    var idDisc = checkboxes[0].value;
    $("#idModifyDisc").val(idDisc);
    $("#modifDiscForm").submit();
}

function deleteDiscipline() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, выберите хотя бы одну дисциплину!");
        return;
    }

    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsDeleteDisc").val(ids);
    $("#deleteDiscForm").submit();

}

    function studentProgress() {
        var checkboxes = $('input[type=checkbox]:checked');
        if(checkboxes.length == 0){
            alert("Пожалуйста, выберите хотя бы одного студента!");
            return;
        }

        if(checkboxes.length > 1){
            alert("Пожалуйста, выберите только одного студента!");
            return;
        }

        var idStud = checkboxes[0].value;
        $("#idStudentProgress").val(idStud);
        $("#StudentProgressForm").submit();
}

function modifyStudent() {
    var checkboxes = $('input[type=checkbox]:checked');
    if(checkboxes.length == 0){
        alert("Пожалуйста, выберите хотя бы одного студента!");
        return;
    }

    if(checkboxes.length > 1){
        alert("Пожалуйста, выберите только одного студента!");
        return;
    }

    var idStud = checkboxes[0].value;
    $("#idModifyStudent").val(idStud);
    $("#ModifyStudentForm").submit();
}

function deleteStudent() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, выберите хотя бы одну дисциплину!");
        return;
    }

    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsStudent").val(ids);
    $("#deleteStudentForm").submit();
}