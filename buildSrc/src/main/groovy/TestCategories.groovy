class TestCategories {
    protected static final String E2E_CATEGORY_CLASS = "e2e.utils.categories.E2E"
    protected static final String API_CATEGORY_CLASS = "e2e.utils.categories.API"

    private static final groupDefinitions = [
            "e2e"   : E2E_CATEGORY_CLASS,
            "api"   : API_CATEGORY_CLASS
    ]

    private final Collection<String> groupsParam

    TestCategories(String group) {
        groupsParam = (group ?: "")
                .split(",")
                .toList()
                .findAll { !it.isAllWhitespace() }
    }

    String[] excludedGroups() {
        resolveGroups(excludes())
    }

    String[] includedGroups() {
        resolveGroups(includes())
    }

    private static String[] resolveGroups(Collection<String> group) {
        group
                .collect { groupDefinitions[it] }
                .toArray(new String[group.size()]) - null
    }

    private Collection<String> includes() {
        groupsParam.findAll { !isExcluded(it) }
    }

    private Collection<String> excludes() {
        groupsParam
                .findAll { isExcluded(it) }
                .collect { it.replaceFirst("-", "") }
    }

    private static boolean isExcluded(String group) {
        group.startsWith("-")
    }
}
