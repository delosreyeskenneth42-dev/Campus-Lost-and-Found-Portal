
var searchInput = document.getElementById("search-input");
var statusFilter = document.getElementById("status-filter");

var itemCards = document.querySelectorAll(".item-card");

function filterItems() {

    var searchText = searchInput.value.toLowerCase();
    var selectedStatus = statusFilter.value;

    itemCards.forEach(function (card) {

        var itemName = card.querySelector("h3").textContent.toLowerCase();

        var itemStatus = card.querySelector(".status-badge").textContent.toLowerCase();

        var matchesSearch = itemName.includes(searchText);

        var matchesStatus =
            selectedStatus === "all" || itemStatus === selectedStatus;

        if (matchesSearch && matchesStatus) {
            card.style.display = "";
        } else {
            card.style.display = "none";
        }

    });

}

searchInput.addEventListener("input", filterItems);

statusFilter.addEventListener("change", filterItems);
