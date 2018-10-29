/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.echobox.api.linkedin.types;

import lombok.Getter;

/**
 * Industry code
 * @author Joanna
 *
 */
public enum IndustryCode implements CodeType<Integer> {
  
  ACCOUNTING(47, Group.CORP, Group.FIN),
  ARLINES_AVIATION(94, Group.MAN, Group.TECH, Group.TRAN),
  ALTERNATIVE_DISPUTE_RESOLUTION(120, Group.LEG, Group.ORG),
  ALTERNATIVE_MEDICINE(125, Group.HLTH),
  ANIMATION(127, Group.ART, Group.MED),
  APPAREL_FASHION(19, Group.GOOD),
  ARCHITECTURE_PLANNING(50, Group.CONS),
  ARTS_CRAFTS(111, Group.ART, Group.MED, Group.REC),
  AUTOMOTIVE(53, Group.MAN),
  AVIATION_AREOSPACE(52, Group.GOV, Group.MAN),
  BANKING(14, Group.FIN),
  BIOTECHNOLOGY(12, Group.GOV, Group.HLTH, Group.TECH),
  BROADCAST_MEDIA(36, Group.MED, Group.REC),
  BUILDING_MATERIALS(49, Group.CONS),
  BUSINESS_SUPPLIES_EQUIPMENT(138, Group.CORP, Group.MAN),
  CAPITAL_MARKETS(129, Group.FIN),
  CHEMICALS(54, Group.MAN),
  CIVIC_SOCIAL_ORGANISATION(90, Group.ORG, Group.SERV),
  CIVIL_ENGINEERING(51, Group.CONS, Group.GOV),
  COMMERCIAL_REAL_ESTATE(128, Group.CONS, Group.CORP, Group.FIN),
  COMPUTER_NETWORK_SECURITY(118, Group.TECH),
  COMPUTER_GAMES(109, Group.MED, Group.REC),
  COMPUTER_HARDWARE(3, Group.TECH),
  COMPUTER_NETWORKING(5, Group.TECH),
  COMPUTER_SOFTWARE(4, Group.TECH),
  CONSTRUCTION(48, Group.CONS),
  CONSUMER_ELECTRONICS(24, Group.GOOD, Group.MAN),
  CNSUMER_GOODS(25, Group.GOOD, Group.MAN),
  CONSUMER_SERVICES(91, Group.ORG, Group.SERV),
  COSMETICS(18, Group.GOOD),
  DAIRY(65, Group.AGR),
  DEFENSE_SPACE(1, Group.GOV, Group.TECH),
  DESIGN(99, Group.ART, Group.MED),
  EDUCATIONAL_MANAGEMENT(69, Group.EDU),
  E_LEARNING(132, Group.EDU, Group.MAN),
  ELECTRONICAL_ELECTRONIC_MANUFACTORING(112, Group.GOOD, Group.MAN),
  ENTERTAINMENT(28, Group.MED, Group.REC),
  ENVIRONMENTAL_SERVICES(86, Group.ORG, Group.SERV),
  EVENTS_SERVICES(110, Group.CORP, Group.REC, Group.SERV),
  EXECUTIVE_OFFICE(76, Group.GOV),
  FACILITIES_SERVICES(122, Group.CORP, Group.SERV),
  FARMING(63, Group.AGR),
  FINANCIAL_SERVICES(43, Group.FIN),
  FINE_ART(38, Group.ART, Group.MED, Group.REC),
  FISHERY(66, Group.AGR),
  FOOD_BEVERAGES(34, Group.REC, Group.SERV),
  FOOD_PRODUCTION(23, Group.GOOD, Group.MAN, Group.SERV),
  FUND_RAISING(101, Group.AGR),
  FURNITURE(26, Group.GOOD, Group.MAN),
  GAMBLING_CASINOS(29, Group.REC),
  GLASS_CERMAICS_CONCRETE(145, Group.CONS, Group.MAN),
  GOVENMENT_ADMINISTRATION(75, Group.GOV),
  GOVERNMENT_RELATIONS(148, Group.GOV),
  GRAPHIC_DESIGN(140, Group.GOV),
  HEALTH_WELLNESS_FITNESS(124, Group.HLTH, Group.REC),
  HIGHER_EDUCATION(68, Group.EDU),
  HOSPITAL_HEALTH_CARE(14, Group.HLTH),
  HOSPITALITY(31, Group.REC, Group.SERV, Group.TRAN),
  HUMAN_RESOURCES(137, Group.CORP),
  IMPORT_EXPORT(134, Group.CORP, Group.GOOD, Group.TRAN),
  INDIVIDUAL_FAMILY_SERVICES(88, Group.ORG, Group.SERV),
  INDUSTRIAL_AUTOMATION(147, Group.CONS, Group.MAN),
  INFORMATIONAL_SERVICES(84, Group.MED, Group.SERV),
  INFORMATIONAL_TECHNOLOGY_SERVICES(96, Group.TECH),
  INSURANCE(42, Group.FIN),
  INTERNATIONAL_AFFAIRS(74, Group.GOV),
  INTERNATIONAL_TRADE_DEVELOPMENT(141, Group.GOV, Group.ORG, Group.TRAN),
  INTERNET(6, Group.TECH),
  INVESTMENT_BANKING(45, Group.FIN),
  INVESTMENT_MANAGEMENT(46, Group.FIN),
  JUDICIARY(73, Group.GOV, Group.LEG),
  LAW_INFORCEMENT(77, Group.GOV, Group.LEG),
  LAW_PRACTICE(9, Group.LEG),
  LEGAL_SERVICES(10, Group.LEG),
  LEGISLATIVE_OFFICE(72, Group.GOV, Group.LEG),
  LESUIRE_TRAVEL_TOURISM(30, Group.GOV, Group.LEG),
  LIBRARIES(85, Group.MED, Group.REC, Group.SERV),
  LOGISTICS_SUPPLY_CHAIN(116, Group.CORP, Group.TRAN),
  LUXURY_GOODS_JEWELRY(143, Group.GOOD),
  MACHINERY(55, Group.MAN),
  MANAGEMENT_CONSULTING(11, Group.CORP),
  MARITIME(95, Group.TRAN),
  MARKET_RESEARCH(97, Group.CORP),
  MARKETING_ADVERTISING(80, Group.CORP, Group.MED),
  MECHANICAL_INDUSTRIAL_ENGINEERING(135, Group.CONS, Group.GOV, Group.MAN),
  MEDIA_PRODUCTION(126, Group.MED, Group.REC),
  MEDICAL_DEVICES(17, Group.HLTH),
  MEDICAL_PRACTICIES(13, Group.HLTH),
  MENTAL_HEALTH_CARE(139, Group.HLTH),
  MILITARY(71, Group.GOV),
  MINING_MATERIALS(56, Group.MAN),
  MOTION_PICTURES_FILM(35, Group.ART, Group.MED, Group.REC),
  MUSEUMS_INSTITUTIONS(37, Group.ART, Group.MED, Group.REC),
  MUSIC(115, Group.ART, Group.REC),
  NANOTECHNOLOGY(114, Group.GOV, Group.MAN, Group.TECH),
  NEWSPAPERS(81, Group.MED, Group.REC),
  NON_PROFIT_ORGANIZATION_MANAGEMENT(100, Group.ORG),
  OIL_ENERGY(57, Group.MAN),
  ONLINE_MEDIA(113, Group.MED),
  OUTSOURCING_OFFSHORING(123, Group.CORP),
  PACKAGE_FREIGHT_DELIVERY(87, Group.SERV, Group.TRAN),
  PACKAGING_CONTAINERS(146, Group.GOOD, Group.MAN),
  PAPER_FOREST_PRODUCTS(61, Group.MAN),
  PERFORMING_ARTS(39, Group.ART, Group.MED, Group.REC),
  PHARMACEUTICALS(15, Group.HLTH, Group.TECH),
  PHILANTHROPY(131, Group.ORG),
  PHOTOGRAPHY(136, Group.ART, Group.MED, Group.REC),
  PLASTICS(117, Group.MAN),
  POLITICAL_ORGANIZATION(107, Group.GOV, Group.ORG),
  PRIMARY_SECONDARY_EDUCATION(67, Group.EDU),
  PRINTING(83, Group.MED, Group.REC),
  PROFESSIONAL_TRAINING_COACHING(105, Group.CORP),
  PROGRAM_DEVELOPMENT(102, Group.CORP, Group.ORG),
  PUBLIC_POLICY(79, Group.GOV),
  PUBLIC_RELATIONS_COMMUNICATIONS(98, Group.CORP),
  PUBLIC_SAFETY(78, Group.GOV),
  PUBLISHING(82, Group.MED, Group.REC),
  RAILROAD_MANUFACTURE(62, Group.MAN),
  RANCHING(64, Group.AGR),
  REAL_ESTATE(44, Group.CONS, Group.FIN, Group.GOOD),
  RECREATIONAL_FACILITIES_SERVICES(40, Group.REC, Group.SERV),
  RELIGIOUS_INSTITUTIONS(89, Group.ORG, Group.SERV),
  RENEWABLES_ENVIRONMENT(144, Group.GOV, Group.MAN, Group.ORG),
  RESEARCH(70, Group.EDU, Group.GOV),
  RESTAURANTS(32, Group.REC, Group.SERV),
  RETAIL(27, Group.GOOD, Group.MAN),
  SECURITY_INVESTIGATIONS(121, Group.CORP, Group.ORG, Group.SERV),
  SEIMCONDUCTORS(7, Group.TECH),
  SHIPBUILDING(58, Group.MAN),
  SPORTING_GOODS(20, Group.GOOD, Group.REC),
  SPORTS(33, Group.REC),
  STAFFING_RECRUITING(104, Group.CORP),
  SUPERMARKETS(22, Group.GOOD),
  TELECOMMUNICATIONS(8, Group.GOV, Group.TECH),
  TEXTILES(60, Group.MAN),
  THINK_TANKS(130, Group.GOV, Group.ORG),
  TOBACCO(21, Group.GOOD),
  TRANSLATION_LOCALIZATION(108, Group.CORP, Group.GOV, Group.SERV),
  TRANSPORTATION_TRUCKING_RAILROAD(92, Group.TRAN),
  UTILITIES(59, Group.MAN),
  VENTURE_CAPITAL_PRIVATE_EQUITY(106, Group.FIN, Group.TECH),
  VETERINARY(16, Group.HLTH),
  WAREHOUSING(93, Group.TRAN),
  WHOLESALE(133, Group.GOOD),
  WINE_SPIRITS(142, Group.GOOD, Group.MAN, Group.REC),
  WIRELESS(119, Group.TECH),
  WRITING_EDITING(103, Group.ART, Group.MED, Group.REC);
  
  @Getter
  private final Integer code;
  
  @Getter
  private final Group[] groups;
  
  IndustryCode(Integer code, Group... groups) {
    this.code = code;
    this.groups = groups;
  }
  
  /**
   * Group enum
   * @author Joanna
   *
   */
  public enum Group {
    CORP,
    FIN,
    MAN,
    TECH,
    TRAN,
    LEG,
    ORG,
    HLTH,
    ART,
    MED,
    GOOD,
    CONS,
    REC,
    GOV,
    SERV,
    AGR,
    EDU;
  }

}
