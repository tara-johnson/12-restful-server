const HOMEPAGE = "http://localhost:8080/parks";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("delete-park");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
        method: "DELETE"
    }).then(() => {
        window.location = HOMEPAGE;
    });
});

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
    const inputs = ev.target.getElementsByTagName("input");
    const name = inputs[0].value;
    const location = inputs[1].value;
    const area = inputs[2].value;
    const park = {name, location, area};
    const body = JSON.stringify(park);

    fetch(ev.target.action, {
        method: ev.target.getAttribute("method"),
        body: body
    }).then(() => {
        window.location = HOMEPAGE;
    });
})