package com.echobox.api.linkedin.types;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * The company's profile model type
 * @see <a href="https://developer.linkedin.com/docs/fields/company-profile">Company Profile</a>
 * for more informatiom
 * @author Joanna
 *
 */
public class Company extends LinkedInNameType {
  
  /**
   * The unique string identifier of a company.
   */
  @Getter
  @Setter
  private String universalName;
  
  /**
   * Company email domains.
   */
  @Getter
  @Setter
  private List<String> emailDomains;
  
  /**
   * The type of company.
   * @see <a href="https://developer.linkedin.com/docs/fields/company-profile">Company types</a>
   * for more information
   */
  @Getter
  @Setter
  private CodeAndNameType companyType;
  
  /**
   * Company ticker identification for the stock exchange. Available only for public companies.
   */
  @Getter
  @Setter
  private String ticker;
  
  /**
   * Company web site address.
   */
  @Getter
  @Setter
  private String websiteURL;
  
  /**
   * A collection containing a code and name pertaining to the company's industry. 
   * @see <a href="https://developer.linkedin.com/docs/reference/industry-codes">Industry Codes</a>
   * for the list of industries available.
   */
  @Getter
  @Setter
  private List<CodeAndNameType> industries;
  
  /**
   * Company status.
   * @see <a href="https://developer.linkedin.com/docs/fields/company-profile">status</a> for more
   * information
   */
  @Getter
  @Setter
  private CodeAndNameType status;
  
  /**
   * URL for the company logo in JPG format.
   */
  @Getter
  @Setter
  private String logoURL;
  
  /**
   * URL for the company logo in a square format.
   */
  @Getter
  @Setter
  private String squareLogoURL;
  
  /**
   * URL for the company blog.
   */
  @Getter
  @Setter
  private String blogRSSURL;
  
  /**
   * Handle for the company Twitter feed.
   */
  @Getter
  @Setter
  private long twitterId;
  
  /**
   * Number range of employees at the company.
   * @see <a href="https://developer.linkedin.com/docs/fields/company-profile">
   * employee-count-range</a> for more information
   */
  @Getter
  @Setter
  private CodeAndNameType employeeCountRange;
  
  /**
   * Company specialties. Retrieves information from string input.
   */
  @Getter
  @Setter
  private List<String> specialities;
  
  /**
   * Company location.
   */
  @Getter
  @Setter
  private List<Location> locations;
  
  /**
   * Company description. Limit of 500 characters.
   */
  @Getter
  @Setter
  private String description;
  
  /**
   * Stock exchange the company is in. Available only for public companies.
   * @see <a href="https://developer.linkedin.com/docs/fields/company-profile">stock-exchange</a>
   * for more information
   */
  @Getter
  @Setter
  private CodeAndNameType stockExchange;
  
  /**
   * Year listed for the company's founding.
   */
  @Getter
  @Setter
  private int foundedYear;
  
  /**
   * Year listed for when the company closed or was acquired by another.
   */
  @Getter
  @Setter
  private int endYear;
  
  /**
   * The number of followers for the company's profile.
   */
  @Getter
  @Setter
  private int numFollowers;

}
