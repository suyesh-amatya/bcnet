create index IX_B003FF25 on biobank (biobankId);

create index IX_A81162A on biobankattributelists (biobankDbId);
create index IX_6DA6C50B on biobankattributelists (biobankDbId, attributeListName);
create index IX_56503876 on biobankattributelists (biobankDbId, attributeListName, attributeListValue);
create index IX_C703384C on biobankattributelists (biobankId);
create index IX_4FDBDBA9 on biobankattributelists (biobankId, attributeListName);
create index IX_F785D414 on biobankattributelists (biobankId, attributeListName, attributeListValue);

create index IX_62815FF0 on biobankattributelistsmaster (attributeListName);
create index IX_8C07D432 on biobankattributelistsmaster (attributeName);

create index IX_7A797B9D on sample (biobankDbId);
create index IX_6D3180E5 on sample (sampleCollectionDbId);
create index IX_CE24C4C4 on sample (uuid_);

create index IX_1F65AD65 on samplecollection (sampleCollectionId);

create index IX_279BCA7C on samplecollectionattributelists (sampleCollectionDbId);
create index IX_F2DE3B79 on samplecollectionattributelists (sampleCollectionDbId, attributeListName);
create index IX_4EA2BE4 on samplecollectionattributelists (sampleCollectionDbId, attributeListName, attributeListValue);

create index IX_CBAFEBEC on samplecollectionattributelistsmaster (attributeListName);

create index IX_C8AC1C93 on samplecollectioncontact (sampleCollectionDbId);
create index IX_BED040E4 on samplecollectioncontact (sampleCollectionDbId, mainContact);

create index IX_145487B9 on sampleimportlog (uuid_);