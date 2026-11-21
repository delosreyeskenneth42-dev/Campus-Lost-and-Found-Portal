
var clearSearchButton = document.getElementById("clear-search");
var searchInput = document.getElementById("search-input");
var statusFilter = document.getElementById("status-filter");

var itemCards = document.querySelectorAll(".item-card");

function filterItems() {

    var searchText = searchInput.value.toLowerCase();
    var selectedStatus = statusFilter.value;
    var noResults = document.getElementById("no-results");

    var visibleItems = 0;
    itemCards.forEach(function (card) {

        var itemName = card.querySelector("h3").textContent.toLowerCase();

        var itemStatus = card.querySelector(".status-badge").textContent.toLowerCase();

        var matchesSearch = itemName.includes(searchText);

        var matchesStatus =
            selectedStatus === "all" || itemStatus === selectedStatus;

        if (matchesSearch && matchesStatus) {
            card.style.display = "";
            visibleItems++;
        } else {
            card.style.display = "none";
        }
        if (visibleItems === 0) {
            noResults.style.display = "block";
        } else {
            noResults.style.display = "none";
        }
    });

}

searchInput.addEventListener("input", filterItems);

statusFilter.addEventListener("change", filterItems);
clearSearchButton.addEventListener("click", function () {
    searchInput.value = "";
    statusFilter.value = "all";

    filterItems();
});