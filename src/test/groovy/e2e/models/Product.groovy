package e2e.models

import geb.navigator.Navigator

class Product {
    String name
    Float price
    String brand
    String category
    Navigator detailsPageLink

    def goToDetailsPage() {
        detailsPageLink.click()
    }
}
