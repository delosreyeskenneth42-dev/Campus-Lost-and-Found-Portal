
var searchInput = document.getElementById("search-input");
var itemCards = document.querySelectorAll(".item-card");

searchInput.addEventListener("input", function() {

    var searchText = searchInput.value.toLowerCase();

    itemCards.forEach(function(card) {

        var itemName = card.querySelector("h3").textContent.toLowerCase();

        if (itemName.includes(searchText)) {
            card.style.display = "";
        } else {
            card.style.display = "none";
        }

    });

});
