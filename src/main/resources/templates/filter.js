function filterBySpecialty() {
    var selectedSpecialty = document.getElementById("filtroEspecialidade").value.toLowerCase();

    var tableRows = document.querySelectorAll("tbody tr");

    tableRows.forEach(function (row) {
        var specialtyColumn = row.querySelector("td:nth-child(4)");
        var rowSpecialty = specialtyColumn.textContent.trim().toLowerCase();

        if (selectedSpecialty === "" || rowSpecialty.includes(selectedSpecialty)) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}
