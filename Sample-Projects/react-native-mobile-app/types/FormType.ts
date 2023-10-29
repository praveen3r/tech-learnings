export type LoginType = {
  userId: string;
  keyword: string;
};

export type MpinSetUpType = {
  oldMpin: string;
  newMpin: string;
  confirmNewMpin: string;
};

export type ChangeKeywordType = {
  oldKeyword: string;
  newKeyword: string;
  confirmNewKeyword: string;
};

export type CourseType = {
  name: string;
  type: string;
  value?: string;
  author: string;
};

export type SoftwareType = {
  name: string;
  type: string;
  isExecutable: string;
};
