$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Pasindu/IdeaProjects/ikmanBDD/src/test/java/Features/browseAds.feature");
formatter.feature({
  "line": 1,
  "name": "BrowseSpecificAds",
  "description": "This feature allows you to browse ikman.lk with three bedrooms and specific price range",
  "id": "browsespecificads",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3684416000,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Browse the specific ads",
  "description": "",
  "id": "browsespecificads;browse-the-specific-ads",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the webpage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the Property link",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click on the Houses",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I click on Colombo",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I Apply the price range between \"5000000\" and \"7500000\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I apply filter button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select number of beds as \"3\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I display the number of results",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I display all the adds",
  "keyword": "Then "
});
formatter.match({
  "location": "ikmanSteps.iNavigateToTheWebpage()"
});
formatter.result({
  "duration": 3965369600,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iClickOnThePropertyLink()"
});
formatter.result({
  "duration": 4123141400,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iClickOnTheHouses()"
});
formatter.result({
  "duration": 2045441600,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iClickOnColombo()"
});
formatter.result({
  "duration": 1176335100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000000",
      "offset": 33
    },
    {
      "val": "7500000",
      "offset": 47
    }
  ],
  "location": "ikmanSteps.iApplyThePriceRangeBetweenAnd(String,String)"
});
formatter.result({
  "duration": 2149253400,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iApplyFilterButton()"
});
formatter.result({
  "duration": 1557814200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 28
    }
  ],
  "location": "ikmanSteps.iSelectNumberOfBedsAs(String)"
});
formatter.result({
  "duration": 3010622100,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iDisplayTheNumberOfResults()"
});
formatter.result({
  "duration": 226879400,
  "status": "passed"
});
formatter.match({
  "location": "ikmanSteps.iDisplayAllTheAdds()"
});
formatter.result({
  "duration": 22921775900,
  "status": "passed"
});
formatter.after({
  "duration": 2128246100,
  "status": "passed"
});
});